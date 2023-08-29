package pro.midev.mec.presentation.ui.screens.services.service_detail

import pro.midev.mec.presentation.base.BaseViewModel
import pro.midev.mec.presentation.model.ServiceHuman

class ServiceDetailViewModel(
    private val service: ServiceHuman
) : BaseViewModel<ServiceDetailState, ServiceDetailEvent, ServiceDetailAction>(
    ServiceDetailState(service = service)
) {
    override fun obtainEvent(event: ServiceDetailEvent) {
        when (event) {
            else -> {}
        }
    }
}
