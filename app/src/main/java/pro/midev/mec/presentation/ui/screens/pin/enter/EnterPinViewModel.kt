package pro.midev.mec.presentation.ui.screens.pin.enter

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.domain.usecase.account.PinSaveUseCase
import pro.midev.mec.presentation.base.BaseViewModel
import pro.midev.mec.presentation.ui.utils.LaunchEffectTrigger

class EnterPinViewModel(
    private val pinSaveUseCase: PinSaveUseCase,
    private val isLoginMode: Boolean
) : BaseViewModel<EnterPinState, EnterPinEvent, EnterPinAction>(
    EnterPinState(
        isLoginMode = isLoginMode
    )
) {
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
            if (newValue.length == viewState.charCount) { // проверяем на кол-во символов, дальше смотрим с зависимости от МОДА : Первый вход, Поддтверждение и Вход в приложение
                if (viewState.isRepeatMode) {
                    if (viewState.pin == viewState.confirmPin) {
                        viewModelScope.launch {
                            pinSaveUseCase(viewState.confirmPin).collectLatest {
                                action = EnterPinAction.OpenScreenTouchAction
                            }
                        }
                    } else {
                        viewState = viewState.copy(pin = "", errorTrigger = LaunchEffectTrigger(), isErrorMode = true)
                    }
                } else if (viewState.isLoginMode) {
                    // todo
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
