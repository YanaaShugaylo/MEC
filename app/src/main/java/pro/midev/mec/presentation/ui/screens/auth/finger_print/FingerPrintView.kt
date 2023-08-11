package pro.midev.mec.presentation.ui.screens.auth.finger_print

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.components.ButtonOutlined
import pro.midev.mec.presentation.ui.components.ButtonPrimary
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun FingerPrintView(
    state: FingerPrintState,
    eventConsumer: (FingerPrintEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MecTheme.colors.white)
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            painter = painterResource(id = R.drawable.finger_image), contentDescription = "", modifier = Modifier
                .zIndex(2F)
                .weight(1f) // ну по дизайну налазит, можно было конечно вместо toolbar просто стрелочку использоваться?
        )



        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            text = stringResource(id = R.string.finger_print_screen_title),
            color = MecTheme.colors.accent_primary,
            style = MecTheme.typography.h5.semibold,
        )

        Text(
            modifier = Modifier.padding(top = 8.dp, bottom = 16.dp),
            text = stringResource(id = R.string.finger_print_screen_subtitle),
            color = MecTheme.colors.text_primary,
            style = MecTheme.typography.subtitle_1.regular
        )

        ButtonPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            onClick = { eventConsumer(FingerPrintEvent.SaveIsEnabledTouchModeEvent(true)) },
            text = stringResource(id = R.string.finger_print_screen_use_finger_print)
        )

        ButtonOutlined(
            modifier = Modifier
                .padding(top = 16.dp, bottom = 24.dp)
                .fillMaxWidth()
                .height(56.dp),
            onClick = { eventConsumer(FingerPrintEvent.SaveIsEnabledTouchModeEvent(false)) },
            text = stringResource(id = R.string.finger_print_screen_use_pin)
        )


    }
}


@Composable
@Preview
fun FingerPrintViewPreview() {
    MecTheme {
        FingerPrintView(state = FingerPrintState(), eventConsumer = {})
    }
}
