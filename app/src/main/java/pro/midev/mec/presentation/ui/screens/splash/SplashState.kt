package pro.midev.mec.presentation.ui.screens.splash

import androidx.compose.runtime.Immutable
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState

@Immutable
data class SplashState(
    val duration: Long = 10L
) : BaseState


sealed interface SplashEvent : BaseEvent {

    object OnCreate : SplashEvent

}

sealed interface SplashAction : BaseAction {

    object GoToAuthScreen : SplashAction

    data class GoToEnterPinScreen(val isLoginMode: Boolean) : SplashAction

    object GoToMainScreen : SplashAction

}