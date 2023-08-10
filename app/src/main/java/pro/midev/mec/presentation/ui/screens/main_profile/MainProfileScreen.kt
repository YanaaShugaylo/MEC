package pro.midev.mec.presentation.ui.screens.main_profile

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
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import pro.midev.mec.R
import pro.midev.mec.presentation.ext.LocalGlobalNavigator
import pro.midev.mec.presentation.ui.style.MecTheme
import pro.midev.mec.util.LocalBottomSheetNavigator

class MainProfileScreenTab : Tab {

    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(id = R.string.main_tab)
            val icon = painterResource(id = R.drawable.ic_profile_tab)

            return remember {
                TabOptions(
                    index = 0u,
                    title = title,
                    icon = icon
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(
            MainProfileScreen()
        )
    }

}

class MainProfileScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        MainProfileScreen(viewModel = getScreenModel())
    }

}

@Composable
private fun MainProfileScreen(
    viewModel: MainProfileViewModel
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
        MainProfileView(state = state, eventConsumer = viewModel::obtainEvent)
    }


}