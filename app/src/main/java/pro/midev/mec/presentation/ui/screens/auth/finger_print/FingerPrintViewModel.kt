package pro.midev.mec.presentation.ui.screens.auth.finger_print

import pro.midev.mec.presentation.base.BaseViewModel

class FingerPrintViewModel(

) : BaseViewModel<FingerPrintState, FingerPrintEvent, FingerPrintAction>(
    FingerPrintState()
) {
    override fun obtainEvent(event: FingerPrintEvent) {
        when (event) {
            FingerPrintEvent.CloseBtnClick -> {}
            FingerPrintEvent.NextBtnClick -> {}
        }
    }
}