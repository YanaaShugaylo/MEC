package pro.midev.mec.presentation.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
fun SplashView(
    state: SplashState,
    eventConsumer: (SplashEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White)
            .statusBarsPadding()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            text = stringResource(id = R.string.error_server),
            style = MecTheme.typography.h4.semibold,
            color = MecTheme.colors.accent_primary,
            textAlign = TextAlign.Left
        )
    }
}

@Composable
@Preview
private fun SplashPreview() {
    MecTheme() {
        SplashView(
            state = SplashState(duration = 12L),
            eventConsumer = {}
        )
    }
}