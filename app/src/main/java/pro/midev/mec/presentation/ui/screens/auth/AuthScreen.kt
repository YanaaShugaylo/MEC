package pro.midev.mec.presentation.ui.screens.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import pro.midev.mec.presentation.ext.LocalGlobalNavigator
import pro.midev.mec.presentation.ui.style.MecTheme
import pro.midev.mec.util.LocalBottomSheetNavigator



class AuthScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        AuthScreen(viewModel = getScreenModel())
    }

}

@Composable
private fun AuthScreen(
    viewModel: AuthViewModel
) {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current
    val navigator = LocalNavigator.currentOrThrow
    val rootNavigator = LocalGlobalNavigator.current
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)

    LaunchedEffect(action) {
        when (action) {
            is AuthAction.GoToNextScreen -> {}
            null -> {}
        }

    }

    LaunchedEffect(true) {
        viewModel.obtainEvent(AuthEvent.OnCreate)
    }

    MecTheme {
        AuthView(
            state = state,
            eventConsumer = viewModel::obtainEvent
        )
    }
}