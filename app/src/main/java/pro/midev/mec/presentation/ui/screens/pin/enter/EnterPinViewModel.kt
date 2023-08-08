package pro.midev.mec.presentation.ui.screens.pin.enter

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.domain.usecase.account.PinSaveUseCase
import pro.midev.mec.presentation.base.BaseViewModel
import pro.midev.mec.presentation.ui.utils.LaunchEffectTrigger

class EnterPinViewModel(
    private val pinSaveUseCase: PinSaveUseCase
) : BaseViewModel<EnterPinState, EnterPinEvent, EnterPinAction>(EnterPinState()) {
    override fun obtainEvent(event: EnterPinEvent) {
        when (event) {
            EnterPinEvent.OnCharRemove -> {
                onCharRemoved()
            }

            is EnterPinEvent.OnCharAdd -> {
                onCharAdded(event.value)
            }

            EnterPinEvent.OnCreate -> {}
        }
    }

    fun onCharAdded(char: String) {
        val newValue = viewState.pin + char
        if (newValue.length <= viewState.charCount) {
            viewState = viewState.copy(pin = newValue)
            if (newValue.length == viewState.charCount) {
                if (viewState.isRepeatMode) {
                    if (viewState.pin == viewState.confirmPin) {
                        viewModelScope.launch {
                            pinSaveUseCase(viewState.confirmPin).collectLatest {
                                // todo открыть Экран ТOUCH ID
                            }
                        }
                    } else {
                        viewState = viewState.copy(pin = "", errorTrigger = LaunchEffectTrigger())
                    }
                } else {
                    viewState = viewState.copy(isRepeatMode = true, confirmPin = viewState.pin, pin = "")
                }
            }
        }
    }

    private fun onCharRemoved() {
        viewState = viewState.copy(pin = viewState.pin.dropLast(1))
    }
}
