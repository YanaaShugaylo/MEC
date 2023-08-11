package pro.midev.mec.presentation.ui.screens.auth.finger_print

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.domain.usecase.account.SaveIsTouchModeUseCase
import pro.midev.mec.presentation.base.BaseViewModel

class FingerPrintViewModel(
    private val saveIsTouchModeUseCase: SaveIsTouchModeUseCase
) : BaseViewModel<FingerPrintState, FingerPrintEvent, FingerPrintAction>(
    FingerPrintState()
) {
    override fun obtainEvent(event: FingerPrintEvent) {
        when (event) {
            FingerPrintEvent.SkipEvent -> action = FingerPrintAction.Skip
            is FingerPrintEvent.SaveIsEnabledTouchModeEvent -> saveIsTouchModeEnabled(event.isEnabledTouchMode)
        }
    }


    private fun saveIsTouchModeEnabled(isTouchModeEnabled: Boolean) {
        viewModelScope.launch {
            saveIsTouchModeUseCase(isTouchModeEnabled).collectLatest {
                action = FingerPrintAction.Skip
            }
        }
    }
}
