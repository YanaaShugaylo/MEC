package pro.midev.mec.presentation.ui.style

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import pro.midev.mec.presentation.ui.style.colors.LocalMecColors
import pro.midev.mec.presentation.ui.style.colors.MecColors
import pro.midev.mec.presentation.ui.style.colors.darkPalette
import pro.midev.mec.presentation.ui.style.colors.lightPalette
import pro.midev.mec.presentation.ui.style.typography.LocalMecTypography
import pro.midev.mec.presentation.ui.style.typography.MecTypography
import pro.midev.mec.presentation.ui.style.typography.mecTypography

@Composable
fun MecTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val palette = if (darkTheme) darkPalette else lightPalette
    val rippleIndications = rememberRipple()

    CompositionLocalProvider(
        LocalMecColors provides palette,
        LocalMecTypography provides mecTypography,
        LocalIndication provides rippleIndications,
        content = content
    )

}

object MecTheme {
    val colors: MecColors
        @Composable
        @ReadOnlyComposable
        get() = LocalMecColors.current

    val typography: MecTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalMecTypography.current

}
