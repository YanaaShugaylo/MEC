package pro.midev.mec.presentation.ui.screens.services.service_detail

import androidx.compose.runtime.Immutable
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState
import pro.midev.mec.presentation.model.ServiceHuman

@Immutable
data class ServiceDetailState(
    val service: ServiceHuman =  ServiceHuman.getDefault()
) : BaseState

sealed interface ServiceDetailEvent : BaseEvent {

}

sealed interface ServiceDetailAction : BaseAction {

}