package pro.midev.mec.presentation.ui.screens.auth

import pro.midev.mec.presentation.base.BaseViewModel

class AuthViewModel :
    BaseViewModel<AuthState, AuthEvent, AuthAction>(
        AuthState()
    ) {
    override fun obtainEvent(event: AuthEvent) {
        when (event) {
            AuthEvent.OnCreate -> onCreate()
        }
    }

    private fun onCreate() {
        loadAuthWebView()
    }


    private fun loadAuthWebView() {
        viewState = viewState.copy(link = "https://login.mos.ru/sps/oauth/ae?client_id=lk.moscow-export&scope=openid+profile+birthday+usr_grps&redirect_uri=http://mobile.moscow-export.com/login&response_type=code")
    }

}