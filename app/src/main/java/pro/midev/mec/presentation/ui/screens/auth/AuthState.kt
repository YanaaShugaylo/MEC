package pro.midev.mec.presentation.ui.screens.auth

import androidx.compose.runtime.Immutable
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState

@Immutable
data class AuthState(
    val link : String = "https://login.mos.ru/sps/oauth/ae?client_id=lk.moscow-export&scope=openid+profile+birthday+usr_grps&redirect_uri=http://mobile.moscow-export.com/login&response_type=code"
) : BaseState


sealed interface AuthEvent : BaseEvent {

    object OnCreate : AuthEvent

    data class GetTokenEvent(val code : String) : AuthEvent

}

sealed interface AuthAction : BaseAction {

    object GoToNextScreen : AuthAction

}