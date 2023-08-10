package pro.midev.mec.presentation.ui.screens.splash

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.data.base.DataSource
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.domain.usecase.GetAccountUseCase
import pro.midev.mec.domain.usecase.account.PinGetUseCase
import pro.midev.mec.ext.withUI
import pro.midev.mec.presentation.base.BaseViewModel
import retrofit2.HttpException

class SplashViewModel(
    private val getAccountUseCase: GetAccountUseCase,
    private val pinGetUseCase: PinGetUseCase
) : BaseViewModel<SplashState, SplashEvent, SplashAction>(
    SplashState()
) {
    override fun obtainEvent(event: SplashEvent) {
        when (event) {
            SplashEvent.OnCreate -> onCreate()
        }
    }

    private fun onCreate() {
        viewModelScope.launch {
            getAccountUseCase(DataSource.REMOTE).collectLatest { result ->
                when (result) {
                    is DataStatus.Success -> {
                        viewModelScope.launch {
                            getAccountUseCase()
                                .collect { result ->
                                    when (result) {
                                        is DataStatus.Error -> {
                                            if (result.ex is NullPointerException)
                                                withUI { action = SplashAction.GoToEnterPinScreen(isLoginMode = false) }
                                            else
                                                showErrorToast(result.ex)
                                        }

                                        is DataStatus.Success -> {
                                            withUI {
                                                action = SplashAction.GoToEnterPinScreen(isLoginMode = true)
                                            }
                                        }

                                        else -> {}
                                    }
                                }
                        }
                    }

                    is DataStatus.Error -> {
                        if (result.ex is HttpException && result.ex.code() == 401)
                            withUI {
                                action = SplashAction.GoToAuthScreen
                            }
                        else
                            withUI { showErrorToast(result.ex) }
                    }

                    else -> {

                    }
                }
            }
        }
    }
}
