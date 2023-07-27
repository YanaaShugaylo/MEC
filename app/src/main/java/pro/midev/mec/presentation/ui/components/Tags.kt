package pro.midev.mec.presentation.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun Tags(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean = true,
    backgroundColor: Color = MecTheme.colors.accent_primary,
    contentColor: Color = MecTheme.colors.white,
    textStyle: TextStyle = MecTheme.typography.button.semibold,
) {
    TagsBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        contentPadding = PaddingValues(all = 16.dp),
        isEnabled = isEnabled,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        textStyle = textStyle,
    )
}

@Composable
private fun TagsBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    isEnabled: Boolean,
    backgroundColor: Color,
    contentColor: Color,
    textStyle: TextStyle,
) {
    TagBase(
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
                MecTheme.colors.bg_secondary,
        ),
        isEnabled = isEnabled,
        textStyle = textStyle,
    )
}

@Composable
private fun TagBase(
    modifier: Modifier = Modifier.width(99.dp).height(34.dp),
    onClick: () -> Unit,
    text: String?,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    colors: ButtonColors,
    isEnabled: Boolean,
    textStyle: TextStyle?,
    border: BorderStroke? = null,
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
                    style = textStyle,
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true, widthDp = 200)
private fun PreviewButtons() {
    val modifier = Modifier.fillMaxWidth()
    MecTheme {
        Row(
            modifier = Modifier,
        ) {
            Column(
                modifier = Modifier
                    .weight(0.25f)
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Tags(modifier = modifier, onClick = { }, text = "Preview", isEnabled = true)
                Tags(modifier = modifier, onClick = { }, text = "Preview", isEnabled = false)
            }
        }
    }
}
