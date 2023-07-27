package pro.midev.mec.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun ButtonPrimary(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    backgroundColor: Color = MecTheme.colors.accent_primary,
    iconId: Int? = null,
    paddingIconStart: Dp? = null,
    paddingIconEnd: Dp? = null,
    paddingIconTop: Dp? = null,
    paddingIconBottom: Dp? = null,
    textStyle: TextStyle = MecTheme.typography.button.semibold
) {
    ButtonPrimaryBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(all = 16.dp),
        isEnabled = isEnabled,
        backgroundColor = backgroundColor,
        iconId = iconId,
        textStyle = textStyle,
        paddingIconStart = paddingIconStart,
        paddingIconTop = paddingIconTop,
        paddingIconEnd = paddingIconEnd,
        paddingIconBottom = paddingIconBottom
    )
}

@Composable
fun ButtonOutlined(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    backgroundColor: Color = MecTheme.colors.white,
    contentColor: Color = MecTheme.colors.accent_primary,
    iconId: Int? = null,
    textStyle: TextStyle = MecTheme.typography.button.semibold,
) {
    ButtonOutlinedBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(all = 16.dp),
        isEnabled = isEnabled,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        iconId = iconId,
        textStyle = textStyle,
    )
}

@Composable
fun ButtonInactive(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    backgroundColor: Color = MecTheme.colors.text_quaternary,
    contentColor: Color = MecTheme.colors.white,
    iconId: Int? = null,
    textStyle: TextStyle = MecTheme.typography.button.semibold
) {
    ButtonBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(all = 16.dp),
        isEnabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor
        ),
        iconId = iconId,
        textStyle = textStyle
    )
}

@Composable
fun IconButtonFavorite(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    isEnabled: Boolean,
    backgroundColor: Color = MecTheme.colors.accent_primary,
    textStyle: TextStyle? = null,
    text: String? = null,
    paddingIconStart: Dp? = null,
    paddingIconEnd: Dp? = null,
    paddingIconTop: Dp? = null,
    paddingIconBottom: Dp? = null,
    contentPadding: PaddingValues = PaddingValues(1.dp)
) {
    ButtonBase(
        modifier = modifier,
        contentPadding = contentPadding,
        onClick = onClick,
        iconId = if (isEnabled) R.drawable.icon_favorite_white
        else R.drawable.icon_favorite_transparent,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            disabledBackgroundColor = if (isEnabled)
                backgroundColor
            else
                Color.Transparent,
            contentColor = MecTheme.colors.white,
            disabledContentColor = if (isEnabled)
                MecTheme.colors.white
            else
                MecTheme.colors.accent_primary
        ),
        textStyle = textStyle,
        isEnabled = isEnabled,
        border = if (isEnabled) BorderStroke(1.dp, MecTheme.colors.accent_primary)
        else BorderStroke(1.dp, MecTheme.colors.accent_primary),
        text = text,
        paddingIconStart = paddingIconStart,
        paddingIconBottom = paddingIconBottom,
        paddingIconEnd = paddingIconEnd,
        paddingIconTop = paddingIconTop,
    )
}


@Composable
private fun ButtonOutlinedBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    isEnabled: Boolean,
    backgroundColor: Color,
    contentColor: Color,
    iconId: Int? = null,
    textStyle: TextStyle,
) {
    ButtonBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = contentColor,
            disabledContentColor = if (isEnabled)
                contentColor
            else
                MecTheme.colors.text_tertiary,
            disabledBackgroundColor = if (isEnabled)
                backgroundColor
            else
                backgroundColor,
        ),
        isEnabled = isEnabled,
        iconId = iconId,
        textStyle = textStyle,
        border = if (isEnabled) BorderStroke(1.dp, MecTheme.colors.accent_primary)
        else BorderStroke(1.dp, MecTheme.colors.text_tertiary)
    )
}

@Composable
private fun ButtonPrimaryBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    isEnabled: Boolean,
    backgroundColor: Color,
    iconId: Int? = null,
    textStyle: TextStyle,
    paddingIconStart: Dp? = null,
    paddingIconTop: Dp? = null,
    paddingIconEnd: Dp? = null,
    paddingIconBottom: Dp? = null
) {
    ButtonBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = MecTheme.colors.white,
            disabledBackgroundColor = if (isEnabled)
                backgroundColor
            else
                Color.Transparent,
            disabledContentColor = if (isEnabled)
                MecTheme.colors.white
            else
                MecTheme.colors.black
        ),
        isEnabled = isEnabled,
        iconId = iconId,
        textStyle = textStyle,
        paddingIconStart = paddingIconStart,
        paddingIconBottom = paddingIconBottom,
        paddingIconEnd = paddingIconEnd,
        paddingIconTop = paddingIconTop
    )
}

@Composable
private fun ButtonBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String?,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    colors: ButtonColors,
    isEnabled: Boolean,
    iconId: Int?,
    textStyle: TextStyle?,
    border: BorderStroke? = null,
    paddingIconStart: Dp? = null,
    paddingIconEnd: Dp? = null,
    paddingIconTop: Dp? = null,
    paddingIconBottom: Dp? = null,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = isEnabled,
        contentPadding = contentPadding,
        colors = colors,
        elevation = null,
        shape = MaterialTheme.shapes.large,
        border = border
    ) {
        if (text != null) {
            if (textStyle != null) {
                Text(
                    text = text,
                    style = textStyle
                )
            }
        }

        iconId?.let {
            if (paddingIconStart != null && paddingIconBottom != null && paddingIconEnd != null && paddingIconTop != null)
                Icon(
                    modifier = Modifier.padding(
                        start = paddingIconStart,
                        end = paddingIconEnd,
                        top = paddingIconTop,
                        bottom = paddingIconBottom
                    ),
                    painter = painterResource(it), contentDescription = ""
                )
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 800)
private fun PreviewButtons() {
    val modifier = Modifier.fillMaxWidth()
    MecTheme {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            Column(
                modifier = Modifier
                    .weight(0.25f)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                ButtonPrimary(modifier = modifier, onClick = { }, text = "Preview")
                ButtonPrimary(modifier = modifier, onClick = { }, text = "Preview", isEnabled = false)
                ButtonPrimary(
                    modifier = modifier,
                    onClick = { },
                    text = "Preview",
                    iconId = R.drawable.arrow_right,
                    paddingIconStart = 16.dp,
                    paddingIconTop = 8.dp,
                    paddingIconEnd = 8.dp,
                    paddingIconBottom = 8.dp
                )
                ButtonOutlined(modifier = modifier, onClick = { }, text = "Preview", isEnabled = true)
                ButtonOutlined(modifier = modifier, onClick = { }, text = "Preview", isEnabled = false)
                ButtonInactive(modifier = modifier, onClick = { }, text = "Preview")
            }
            Column(
                modifier = Modifier
                    .weight(0.25f)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                IconButtonFavorite(
                    onClick = {},
                    isEnabled = false,
                    paddingIconStart = 8.dp,
                    paddingIconTop = 8.dp,
                    paddingIconEnd = 8.dp,
                    paddingIconBottom = 8.dp
                )
                IconButtonFavorite(
                    onClick = {},
                    isEnabled = true,
                    paddingIconStart = 8.dp,
                    paddingIconTop = 8.dp,
                    paddingIconEnd = 8.dp,
                    paddingIconBottom = 8.dp
                )
            }
        }

    }
}
