package pro.midev.mec.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import pro.midev.mec.presentation.ui.screens.main_profile.MainProfileScreenTab
import pro.midev.mec.presentation.ui.screens.services.MainServicesScreenTab
import pro.midev.mec.presentation.ui.style.MecTheme

class MainScreen : AndroidScreen() {
    @Composable
    override fun Content() {
        MecTheme {
            TabNavigator(tab = MainProfileScreenTab()) { tabNavigator ->
                Scaffold(
                    modifier = Modifier.navigationBarsPadding(),
                    backgroundColor = MecTheme.colors.white,
                    content = {
                        Box(modifier = Modifier.padding(bottom = it.calculateBottomPadding())) {
                            CurrentTab()
                        }
                    },
                    bottomBar = {
                        BottomNavigation(
                            elevation = 0.dp,
                            backgroundColor = MecTheme.colors.white
                        ) {
                            TabNavigationItem(tab = MainProfileScreenTab())
                            TabNavigationItem(tab = MainServicesScreenTab())
                            TabNavigationItem(tab = MainProfileScreenTab())
                            TabNavigationItem(tab = MainProfileScreenTab())
                            TabNavigationItem(tab = MainProfileScreenTab())
                        }
                    }
                )
            }
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        val isSelected = tabNavigator.current.key == tab.key
        BottomNavigationItem(
            selected = isSelected,
            onClick = { tabNavigator.current = tab },
            label = {
                Text(
                    text = tab.options.title,
                    style = if (isSelected) MecTheme.typography.nav_item.semibold else MecTheme.typography.nav_item.regular,
                    color = MecTheme.colors.accent_primary
                )
            },
            icon = {

                Box() {
                    Icon(
                        modifier = Modifier.zIndex(1F),
                        painter = tab.options.icon!!,
                        contentDescription = tab.options.title,
                        tint = MecTheme.colors.accent_primary
                    )
                }

            }
        )
    }
}
