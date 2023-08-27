package pro.midev.mec.presentation.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
fun SplashView(
    state: SplashState,
    eventConsumer: (SplashEvent) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MecTheme.colors.white)
            .statusBarsPadding()
            .navigationBarsPadding()
    )
    {

        Image(
            painterResource(id = R.drawable.splash),
            modifier = Modifier.align(Alignment.Center),
            contentDescription = ""
        )

        CircularProgressIndicator(
            modifier = Modifier
                .padding(bottom = 40.dp)
                .align(Alignment.BottomCenter)
                .size(53.dp), color = MecTheme.colors.accent_primary, strokeWidth = 6.dp
        )

        Icon(
            tint = MecTheme.colors.accent_primary,
            painter = painterResource(id = R.drawable.line_splash_ic),
            contentDescription = "",
            modifier = Modifier.align(Alignment.BottomEnd)
        )
    }
}

@Composable
@Preview
private fun SplashPreview() {
    MecTheme {
        SplashView(
            state = SplashState(),
            eventConsumer = {}
        )
    }
}