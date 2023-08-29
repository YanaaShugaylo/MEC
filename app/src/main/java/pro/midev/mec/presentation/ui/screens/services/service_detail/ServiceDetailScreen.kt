package pro.midev.mec.presentation.ui.screens.services.service_detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.koin.getScreenModel
import pro.midev.mec.presentation.ext.LocalGlobalNavigator
import pro.midev.mec.presentation.ui.screens.services.MainServicesEvent
import pro.midev.mec.presentation.ui.screens.services.MainServicesView
import pro.midev.mec.presentation.ui.screens.services.MainServicesViewModel
import pro.midev.mec.presentation.ui.style.MecTheme
import pro.midev.mec.util.LocalBottomSheetNavigator

class ServiceDetailScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        ServiceDetailScreen(viewModel = getScreenModel())
    }
}

@Composable
private fun ServiceDetailScreen(
    viewModel: ServiceDetailViewModel
) {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current
    val navigator = LocalGlobalNavigator.current
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)


    LaunchedEffect(action) {
        when (action) {
            else -> {}
        }
    }


    MecTheme {
        ServiceDetailView(state = state, eventConsumer = viewModel::obtainEvent)
    }


}