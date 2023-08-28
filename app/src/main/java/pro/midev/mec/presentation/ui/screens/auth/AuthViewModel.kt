package pro.midev.mec.presentation.ui.screens.auth

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.domain.usecase.GetTokenUseCase
import pro.midev.mec.presentation.base.BaseViewModel

class AuthViewModel(
    private val getTokenUseCase: GetTokenUseCase
) :
    BaseViewModel<AuthState, AuthEvent, AuthAction>(
        AuthState()
    ) {
    override fun obtainEvent(event: AuthEvent) {
        when (event) {
            AuthEvent.OnCreate -> onCreate()
            is AuthEvent.GetTokenEvent -> getToken(event.code)
        }
    }

    private fun onCreate() {
        loadAuthWebView()
    }


    private fun loadAuthWebView() {
        viewState =
            viewState.copy(link = "https://login.mos.ru/sps/oauth/ae?client_id=lk.moscow-export&scope=openid+profile+birthday+usr_grps&redirect_uri=http://mobile.moscow-export.com/login&response_type=code")
    }

    private fun getToken(code: String) {
        viewModelScope.launch {
            getTokenUseCase(code).collectLatest { result ->
                when (result) {
                    is CompletableStatus.Success -> action = AuthAction.GoToNextScreen
                    is CompletableStatus.Error -> {
                        showErrorToast(result.ex)
                    }

                    is CompletableStatus.Loading -> {
                        //viewState = viewState.copy()
                    }
                }
            }
        }
    }

}