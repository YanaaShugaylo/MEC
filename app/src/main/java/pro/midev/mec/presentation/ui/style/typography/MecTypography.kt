package pro.midev.mec.presentation.ui.style.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import pro.midev.mec.R

@Immutable
data class MecTypography(
    val h4: MecFont,
    val h5: MecFont,
    val h6: MecFont,
    val subtitle_1: MecFont,
    val subtitle_2: MecFont,
    val body_1: MecFont,
    val body_2: MecFont,
    val button: MecFont,
    val caption: MecFont,
    val overline: MecFont,
)

private val mecFontFamily = FontFamily(
    Font(R.font.ceraprobold, FontWeight.W700),
    Font(R.font.ceraproregular, FontWeight.W400),
)

@Immutable
class MecFont(
    fontSize: TextUnit,
    lineHeight: TextUnit
) {

    val regular = TextStyle(
        fontFamily = mecFontFamily,
        fontWeight = FontWeight.W400,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

    val semibold = TextStyle(
        fontFamily = mecFontFamily,
        fontWeight = FontWeight.W700,
        fontSize = fontSize,
        lineHeight = lineHeight
    )

}

val LocalMecTypography = staticCompositionLocalOf<MecTypography> {
    error("No typography provided")
}

val mecTypography = MecTypography(
    h4 = MecFont(
        fontSize = 34.sp,
        lineHeight = 41.sp
    ),
    h5 = MecFont(
        fontSize = 24.sp,
        lineHeight = 28.sp
    ),
    h6 = MecFont(
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    subtitle_1 = MecFont(
        fontSize = 16.sp,
        lineHeight = 20.sp
    ),
    subtitle_2 = MecFont(
        fontSize = 14.sp,
        lineHeight = 18.sp
    ),
    body_1 = MecFont(
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    body_2 = MecFont(
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    button = MecFont(
        fontSize = 14.sp,
        lineHeight = 16.sp
    ),
    caption = MecFont(
        fontSize = 12.sp,
        lineHeight = 16.sp
    ),
    overline = MecFont(
        fontSize = 10.sp,
        lineHeight = 16.sp
    )
)
