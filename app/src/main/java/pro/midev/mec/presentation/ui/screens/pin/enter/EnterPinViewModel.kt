package pro.midev.mec.presentation.ui.screens.pin.enter

import pro.midev.mec.presentation.base.BaseViewModel

class EnterPinViewModel : BaseViewModel<EnterPinState, EnterPinEvent, EnterPinAction>(EnterPinState()) {
    override fun obtainEvent(event: EnterPinEvent) {
        when (event) {
            EnterPinEvent.OnCharRemove -> {}
            is EnterPinEvent.OnCharAdd -> {}
            EnterPinEvent.OnCreate -> {}
        }
    }

    fun onScreenCreated(char : String) {
        val newValue = viewState.pin + char
        if (newValue.length <= viewState.charCount) {
            viewState = viewState.copy(pin = newValue)
            if (newValue.length == viewState.charCount) {
                //onPinEntered(newValue)
            }
        }
    }

    private fun onCharRemoved() {
        viewState = viewState.copy(pin = viewState.pin.dropLast(1))
    }
}
