package pro.midev.mec.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalSavedStateRegistryOwner
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.FadeTransition
import org.koin.core.component.KoinComponent
import pro.midev.mec.R
import pro.midev.mec.data.remote.exceptions.MecRemoteException
import pro.midev.mec.data.remote.exceptions.NoConnectivityException
import pro.midev.mec.events.EventType
import pro.midev.mec.events.Events
import pro.midev.mec.ext.launchIO
import pro.midev.mec.ext.withUI
import pro.midev.mec.presentation.ext.LocalGlobalNavigator
import pro.midev.mec.presentation.ui.screens.SplashScreenDefault
import pro.midev.mec.util.BottomSheetNavigator
import retrofit2.HttpException

class EntryPointActivity : FragmentActivity(), KoinComponent {


    private var keepSplashScreen = true

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen().setKeepOnScreenCondition { keepSplashScreen }

        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        listenToasts()
        listenTextToast()
        start()
    }

    private fun start() {
        openScreen(SplashScreenDefault())
    }


    @OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
    private fun openScreen(screen: AndroidScreen) {
        keepSplashScreen = false
        setContent {
            BottomSheetNavigator(
                sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 0.dp, bottomStart = 0.dp)
            ) {
                Navigator(screen = screen) { navigator ->
                    CompositionLocalProvider(LocalGlobalNavigator provides navigator) {
                        FadeTransition(navigator) {
                            if (LocalSavedStateRegistryOwner.current.lifecycle.currentState != Lifecycle.State.DESTROYED) {
                                it.Content()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun listenToasts() {
        lifecycleScope.launchIO {
            Events.subscribe<EventType.ShowErrorToast> { toastData ->
                withUI { showErrorToast(toastData.ex) }
            }

        }
    }

    private fun listenTextToast() {
        lifecycleScope.launchIO {
            Events.subscribe<EventType.ShowTextToast> { toastText ->
                withUI { Toast.makeText(this, toastText.text, Toast.LENGTH_SHORT).show() }
            }
        }
    }

    private fun showErrorToast(ex: Exception) {
        val message: String = when (ex) {
            is NoConnectivityException -> getString(R.string.error_no_connectivity)
            is MecRemoteException -> ex.remoteMessage
            is HttpException -> when (ex.code()) {
                401 -> getString(R.string.error_unauthorized)
                500 -> getString(R.string.error_server)
                else -> getString(R.string.error_undefined)
            }

            else -> getString(R.string.error_undefined)
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}