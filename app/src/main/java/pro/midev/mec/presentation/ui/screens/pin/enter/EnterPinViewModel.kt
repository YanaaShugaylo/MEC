package pro.midev.mec.presentation.ui.screens.pin.enter

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.domain.usecase.account.GetFingerInfoUseCase
import pro.midev.mec.domain.usecase.account.GetIsTouchModeUseCase
import pro.midev.mec.domain.usecase.account.PinGetUseCase
import pro.midev.mec.domain.usecase.account.PinSaveUseCase
import pro.midev.mec.ext.withUI
import pro.midev.mec.presentation.base.BaseViewModel
import pro.midev.mec.presentation.ui.utils.LaunchEffectTrigger

class EnterPinViewModel(
    private val getIsTouchModeUseCase: GetIsTouchModeUseCase,
    private val pinGetUseCase: PinGetUseCase,
    private val pinSaveUseCase: PinSaveUseCase,
    private val getFingerInfoUseCase: GetFingerInfoUseCase, // проверка включен ли отпечаток пальца в приложении
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

            is EnterPinEvent.OnSkip -> action = EnterPinAction.OpenMainScreenAction

            is EnterPinEvent.OnCreate -> onCreate()

        }
    }

    private fun onCreate() {
        viewModelScope.launch {
            getFingerInfoUseCase().collectLatest { result ->
                when (result) {

                    is DataStatus.Success -> {

                        if (result.data) {
                            getIsTouchModeUseCase().collect { resultIsMode ->
                                when (resultIsMode) {

                                    is DataStatus.Success -> {
                                        if (resultIsMode.data) {
                                            viewState = viewState.copy(isTouchIdEnabled = true)
                                        }
                                    }

                                    else -> {}
                                }
                            }
                        }

                    }

                    else -> {

                    }
                }
            }
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

                                getFingerInfoUseCase().collectLatest { result ->
                                    when (result) {

                                        is DataStatus.Success -> {
                                            if (result.data) action = EnterPinAction.OpenScreenTouchAction
                                            else EnterPinAction.OpenMainScreenAction
                                        }

                                        else -> {

                                        }
                                    }
                                }
                                action = EnterPinAction.OpenScreenTouchAction
                            }
                        }
                    } else {
                        viewState = viewState.copy(pin = "", errorTrigger = LaunchEffectTrigger(), isErrorMode = true)
                    }
                } else if (viewState.isLoginMode) {
                    viewModelScope.launch {
                        pinGetUseCase().collect { result ->
                            when (result) {

                                is DataStatus.Success -> {
                                    withUI {
                                        if (result.data == viewState.pin) {
                                            action = EnterPinAction.OpenMainScreenAction
                                        } else {
                                            viewState = viewState.copy(
                                                pin = "",
                                                errorTrigger = LaunchEffectTrigger(),
                                                isErrorMode = true
                                            )
                                        }
                                    }
                                }

                                else -> Unit
                            }
                        }
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
