package pro.midev.mec.presentation.ui.screens.main_profile

import androidx.compose.runtime.Immutable
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState

@Immutable
data class MainProfileState(
    val isTest : Boolean = false
) : BaseState // todo

sealed interface MainProfileEvent : BaseEvent {
    object OnCreate : MainProfileEvent

}

sealed interface MainProfileAction : BaseAction {

}