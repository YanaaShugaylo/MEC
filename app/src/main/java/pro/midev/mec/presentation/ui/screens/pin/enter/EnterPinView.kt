package pro.midev.mec.presentation.ui.screens.pin.enter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.components.TextTitleToolbar
import pro.midev.mec.presentation.ui.screens.pin.components.InputProgressView
import pro.midev.mec.presentation.ui.screens.pin.components.NumpadView
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun EnterPinView(
    state: EnterPinState,
    eventConsumer: (EnterPinEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize().statusBarsPadding()
            .background(color = MecTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextTitleToolbar(
            actionsEnd = {
                Text(
                    modifier = Modifier.padding(end = 12.dp),
                    text = stringResource(id = R.string.skip),
                    color = MecTheme.colors.text_primary,
                    style = MecTheme.typography.subtitle_1.semibold
                )
            },
            onBackPressed = {},
            hasNavigationIcon = true
        )

        Text(
            text = stringResource(id = R.string.pin_enter),
            style = MecTheme.typography.h5.semibold,
            color = MecTheme.colors.accent_primary,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
        )

        Text(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 32.dp)
                .fillMaxWidth(),
            text = stringResource(id = R.string.pin_think),
            style = MecTheme.typography.subtitle_1.regular,
            color = MecTheme.colors.text_secondary
        )

        InputProgressView(
            value = state.pin,
            dotSize = 12.dp,
            dotsCount = state.charCount,
            dotsSpace = 12.dp
        )

        NumpadView(
            removeIcon = R.drawable.ic_x,
            onRemove = { eventConsumer(EnterPinEvent.OnCharRemove) },
            onInput = { eventConsumer(EnterPinEvent.OnCharAdd(it)) },
            modifier = Modifier
                .navigationBarsPadding()
                .padding(top = 32.dp)
        )

    }
}

@Composable
@Preview
private fun EnterPinView() {
    MecTheme {
        EnterPinView(
            state = EnterPinState(),
            eventConsumer = {}
        )
    }
}
