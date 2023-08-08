package pro.midev.mec.presentation.ui.screens.pin.enter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import pro.midev.mec.presentation.ui.style.MecTheme

class EnterPinScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        EnterPinScreen(viewModel = getScreenModel())
    }
}

@Composable
private fun EnterPinScreen(
    viewModel: EnterPinViewModel
) {
    val navigator = LocalNavigator.currentOrThrow
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)

    LaunchedEffect(action) {
        when (action) {
            else -> {}
        }

    }

    MecTheme {
        EnterPinView(state = state, eventConsumer = viewModel::obtainEvent)
    }
}