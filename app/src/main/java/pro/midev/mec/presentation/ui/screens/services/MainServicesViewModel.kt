package pro.midev.mec.presentation.ui.screens.services

import androidx.lifecycle.viewModelScope
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.domain.usecase.services.GetServicesUseCase
import pro.midev.mec.ext.withUI
import pro.midev.mec.presentation.base.BaseViewModel

class MainServicesViewModel(
    private val getServicesUseCase: GetServicesUseCase
) : BaseViewModel<MainServicesState, MainServicesEvent, MainServicesAction>(
    MainServicesState()
) {
    override fun obtainEvent(event: MainServicesEvent) {
        when (event) {
            MainServicesEvent.OnCreate -> {
                getServices()
            }

            is MainServicesEvent.ChangeTypeServices -> {
                viewState = viewState.copy(typeService = event.type)
            }

            is MainServicesEvent.ChangeInn -> {
                viewState = viewState.copy(inn = event.inn)
            }

            MainServicesEvent.RemoveInn -> viewState = viewState.copy(inn = null)
        }
    }

    override fun onDispose() {
        super.onDispose()
    }

    private fun getServices() {
        viewModelScope.launch {
            getServicesUseCase().collectLatest { result ->
                when (result) {

                    is DataStatus.Loading -> {
                        viewState = viewState.copy(isLoading = true)
                    }

                    is DataStatus.Success -> {
                        withUI {
                            viewState =
                                viewState.copy(isLoading = false, services = result.data.filter { !it.invisible }
                                    .toImmutableList())
                        }
                    }

                    is DataStatus.Error -> {
                        viewState = viewState.copy(isLoading = false)
                        showErrorToast(result.ex)
                    }

                }
            }
        }
    }

}