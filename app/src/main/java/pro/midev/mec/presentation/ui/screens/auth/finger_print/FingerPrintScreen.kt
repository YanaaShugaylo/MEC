package pro.midev.mec.presentation.ui.screens.auth.finger_print

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import pro.midev.mec.presentation.ui.style.MecTheme

class FingerPrintScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        FingerPrintScreen(viewModel = getScreenModel())
    }
}

@Composable
private fun FingerPrintScreen(
    viewModel: FingerPrintViewModel
) {
    val navigator = LocalNavigator.currentOrThrow
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)

    LaunchedEffect(action) {
        when (val act = action) {
            else -> {}
        }
    }

    MecTheme {
        FingerPrintView(
            state = state,
            eventConsumer = viewModel::obtainEvent
        )
    }

}
