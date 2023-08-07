package pro.midev.mec.presentation.ui.screens.pin.enter

import androidx.compose.runtime.Immutable
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState

@Immutable
data class EnterPinState(
    val pin: String = "",
    val isFirst: Boolean = false,
    val name: String = "",
    val isTouchIdEnabled: Boolean = false

) : BaseState {
    val charCount: Int = 6
}


sealed interface EnterPinEvent : BaseEvent {

    object OnCreate : EnterPinEvent
    data class OnCharAdd(val value: String) : EnterPinEvent
    object OnCharRemove : EnterPinEvent

}

sealed interface EnterPinAction : BaseAction {

}
