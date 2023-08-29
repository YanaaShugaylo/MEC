package pro.midev.mec.presentation.ui.screens.services

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import pro.midev.mec.enum.TypeServices
import pro.midev.mec.presentation.base.BaseAction
import pro.midev.mec.presentation.base.BaseEvent
import pro.midev.mec.presentation.base.BaseState
import pro.midev.mec.presentation.model.ServiceHuman

@Immutable
data class MainServicesState(
    val typeService: TypeServices = TypeServices.FINANCES,
    val services: ImmutableList<ServiceHuman> = persistentListOf(),
    val inn: String? = null,
    val isLoading: Boolean = false
) : BaseState

sealed interface MainServicesEvent : BaseEvent {

    object OnCreate : MainServicesEvent

    data class ChangeTypeServices(val type: TypeServices) : MainServicesEvent

    data class ChangeInn(val inn: String) : MainServicesEvent

    object RemoveInn : MainServicesEvent

}

sealed interface MainServicesAction : BaseAction {

}