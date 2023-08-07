package pro.midev.mec.presentation.ui.screens.splash

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.data.base.DataSource
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.domain.usecase.GetAccountUseCase
import pro.midev.mec.ext.withUI
import pro.midev.mec.presentation.base.BaseViewModel
import retrofit2.HttpException

class SplashViewModel(
    private val getAccountUseCase: GetAccountUseCase
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
                        action = SplashAction.GoToEnterPinScreen
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
