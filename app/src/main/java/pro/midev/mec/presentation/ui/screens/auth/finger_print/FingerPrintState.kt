package pro.midev.mec.presentation.ui.screens.auth.finger_print

import androidx.compose.runtime.Immutable
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState

@Immutable
class FingerPrintState : BaseState

sealed interface FingerPrintEvent : BaseEvent {
    object CloseBtnClick : FingerPrintEvent
    object NextBtnClick : FingerPrintEvent
}

sealed interface FingerPrintAction : BaseAction {

    object Skip : FingerPrintAction

}
