package pro.midev.mec.presentation.ui.screens.main_profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun MainProfileView(
    state: MainProfileState,
    eventConsumer: (MainProfileEvent) -> Unit
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .navigationBarsPadding()
        .statusBarsPadding()) {

    }
}

@Composable
@Preview
private fun MainProfileViewPeview() {
    MecTheme {
        MainProfileView(state = MainProfileState(), eventConsumer = {})
    }
}