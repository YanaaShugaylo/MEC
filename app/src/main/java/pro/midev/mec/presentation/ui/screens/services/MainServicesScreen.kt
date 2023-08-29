package pro.midev.mec.presentation.ui.screens.services

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import pro.midev.mec.R
import pro.midev.mec.presentation.ext.LocalGlobalNavigator
import pro.midev.mec.presentation.ui.screens.main_profile.MainProfileView
import pro.midev.mec.presentation.ui.style.MecTheme
import pro.midev.mec.util.LocalBottomSheetNavigator

class MainServicesScreenTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val tabNavigator = LocalTabNavigator.current
            val isSelected = tabNavigator.current.key == this.key // хочу сделать проверку для разных иконок
            val title = stringResource(id = R.string.services)
            val icon =
                painterResource(id = if (isSelected) R.drawable.ic_services_tab else R.drawable.ic_services_tab_unselected)

            return remember {
                TabOptions(
                    index = 1u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(
            MainServicesScreen()
        )
    }

}

class MainServicesScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        MainServicesScreen(viewModel = getScreenModel())
    }

}

@Composable
private fun MainServicesScreen(
    viewModel: MainServicesViewModel
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
        MainServicesView(state = state, eventConsumer = viewModel::obtainEvent)
    }


}