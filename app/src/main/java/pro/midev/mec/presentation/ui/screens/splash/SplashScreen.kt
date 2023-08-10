package pro.midev.mec.presentation.ui.screens.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import pro.midev.mec.presentation.ext.LocalGlobalNavigator
import pro.midev.mec.presentation.ui.screens.auth.AuthScreen
import pro.midev.mec.presentation.ui.screens.pin.enter.EnterPinScreen
import pro.midev.mec.presentation.ui.style.MecTheme
import pro.midev.mec.util.LocalBottomSheetNavigator

class SplashScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        SplashScreen(viewModel = getScreenModel())
    }
}


@Composable
private fun SplashScreen(
    viewModel: SplashViewModel
) {
    val bottomSheetNavigator = LocalBottomSheetNavigator.current
    val navigator = LocalNavigator.currentOrThrow
    val rootNavigator = LocalGlobalNavigator.current
    val state by viewModel.viewStates.collectAsStateWithLifecycle()
    val action by viewModel.viewActions.collectAsStateWithLifecycle(initialValue = null)

    LaunchedEffect(action) {
        when (action) {
            is SplashAction.GoToAuthScreen -> {
                navigator.push(AuthScreen())
            }

            is SplashAction.GoToEnterPinScreen -> {
                (action as? SplashAction.GoToEnterPinScreen)?.let {
                    EnterPinScreen(it.isLoginMode)
                }
            }

            null -> {}
        }

    }

    LaunchedEffect(true) {
        viewModel.obtainEvent(SplashEvent.OnCreate)
    }

    MecTheme {
        SplashView(state = state, eventConsumer = viewModel::obtainEvent)
    }
}
