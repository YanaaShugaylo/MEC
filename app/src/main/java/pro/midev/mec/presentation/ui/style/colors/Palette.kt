package pro.midev.mec.presentation.ui.style.colors

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val lightPalette = MecColors(
    white = Color(0xFFFFFFFF),
    black = Color(0xFF000000),
    text_primary = Color(0xFF202020),
    text_secondary = Color(0xFF717A86),
    text_tertiary = Color(0xFFBAC2CD),
    text_quaternary = Color(0xFFE4E9EF),
    accent_primary = Color(0xFF663399),
    accent_secondary = Color(0xFFF4EBFC),
    accent_tertiary = Color(0xFFFF4261),
    bg_primary = Color(0xFFFFFFFF),
    bg_secondary = Color(0xFFEBEBF1),
    bg_tertiary = Color(0xFFF5F5FA),
    bg_quaternary = Color(0xFFFAFAFA),
    success = Color(0xFF10D05D),
    attention = Color(0xFFFFB800),
    info = Color(0xFF009FD6),
    error = Color(0xFFFF4261)
)

val darkPalette = MecColors(
    white = Color(0xFFFFFFFF),
    black = Color(0xFF000000),
    text_primary = Color(0xFF202020),
    text_secondary = Color(0xFF717A86),
    text_tertiary = Color(0xFFBAC2CD),
    text_quaternary = Color(0xFFE4E9EF),
    accent_primary = Color(0xFF663399),
    accent_secondary = Color(0xFFF4EBFC),
    accent_tertiary = Color(0xFFFF4261),
    bg_primary = Color(0xFFFFFFFF),
    bg_secondary = Color(0xFFEBEBF1),
    bg_tertiary = Color(0xFFF5F5FA),
    bg_quaternary = Color(0xFFFAFAFA),
    success = Color(0xFF10D05D),
    attention = Color(0xFFFFB800),
    info = Color(0xFF009FD6),
    error = Color(0xFFFF4261)
)

val LocalMecColors = staticCompositionLocalOf<MecColors> {
    error("no colors provided")
}
