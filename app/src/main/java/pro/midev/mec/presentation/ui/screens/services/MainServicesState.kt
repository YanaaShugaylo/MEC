package pro.midev.mec.presentation.ui.screens.services

import androidx.compose.runtime.Immutable
import pro.midev.mec.enum.TypeServices
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState

@Immutable
data class MainServicesState(
    val typeService: TypeServices = TypeServices.FINANCES,
    val inn: String? = null,
) : BaseState

sealed interface MainServicesEvent : BaseEvent {

    object OnCreate : MainServicesEvent

    data class ChangeTypeServices(val type: TypeServices) : MainServicesEvent

    data class ChangeInn(val inn: String) : MainServicesEvent

    object RemoveInn : MainServicesEvent

}

sealed interface MainServicesAction : BaseAction {

}