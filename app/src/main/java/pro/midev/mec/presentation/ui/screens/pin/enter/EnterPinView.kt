package pro.midev.mec.presentation.ui.screens.pin.enter

import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
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

    var useBio by remember { mutableStateOf(false) }

    if (useBio) {
        useBio = false
        BiometricDialog(object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                eventConsumer(EnterPinEvent.OnSkip)
            }
        })
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .background(color = MecTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextTitleToolbar(
            actionsEnd = {
                if (!state.isLoginMode)
                    Text(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .clickable { },
                        text = stringResource(id = R.string.skip),
                        color = MecTheme.colors.text_primary,
                        style = MecTheme.typography.subtitle_1.semibold
                    )
            },
            onBackPressed = {},
            hasNavigationIcon = true
        )

        Text(
            text = stringResource(
                id = when {
                    state.isErrorMode && state.isRepeatMode -> R.string.pin_enter
                    !state.isErrorMode && state.isRepeatMode -> R.string.pin_confirm
                    !state.isRepeatMode && !state.isErrorMode -> R.string.pin_enter
                    state.isLoginMode -> R.string.pin_enter
                    else -> R.string.pin_enter // todo
                }
            ),
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
            text = stringResource(
                id = when {
                    state.isErrorMode && state.isRepeatMode -> R.string.pin_entered_wrong
                    !state.isErrorMode && state.isRepeatMode -> R.string.pin_confirm_desc
                    !state.isRepeatMode && !state.isErrorMode && !state.isLoginMode -> R.string.pin_think
                    state.isLoginMode && !state.isErrorMode -> R.string.pin_login_desc
                    state.isLoginMode && state.isErrorMode && !state.isRepeatMode -> R.string.pin_entered_wrong
                    else -> R.string.pin_enter // todo
                }
            ),
            style = MecTheme.typography.subtitle_1.regular,
            color = MecTheme.colors.text_secondary
        )

        InputProgressView(
            value = state.pin,
            dotSize = 12.dp,
            dotsCount = state.charCount,
            dotsSpace = 12.dp,
            errorTrigger = state.errorTrigger
        )

        NumpadView(
            removeIcon = R.drawable.ic_x,
            onRemove = { eventConsumer(EnterPinEvent.OnCharRemove) },
            onInput = { eventConsumer(EnterPinEvent.OnCharAdd(it)) },
            modifier = Modifier
                .navigationBarsPadding()
                .padding(top = 32.dp),
            onActionClick = if (!state.isTouchIdEnabled) null else {
                { useBio = true }
            }
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

@Composable
fun BiometricDialog(callback: BiometricPrompt.AuthenticationCallback) {
    val promptInfo = BiometricPrompt.PromptInfo.Builder()
        .setTitle(stringResource(R.string.pin_confirm_sensor_auth))
        .setNegativeButtonText(stringResource(R.string.cancel))
        .setDescription(stringResource(R.string.pin_confirm_sensor_auth_description))
        .build()

    val activity = LocalContext.current as FragmentActivity
    val executor = ContextCompat.getMainExecutor(activity)
    BiometricPrompt(activity, executor, callback).authenticate(promptInfo)
}

