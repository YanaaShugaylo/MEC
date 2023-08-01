package pro.midev.mec.presentation.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
) {
    TagsBase(
        modifier = modifier,
        onClick = onClick,
        text = text,
        isEnabled = isEnabled,
        backgroundColor = if (isEnabled)
            backgroundColor
        else
            MecTheme.colors.bg_secondary,
        contentColor = if (isEnabled)
            contentColor
        else
            MecTheme.colors.text_tertiary
    )
}

@Composable
private fun TagsBase(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    isEnabled: Boolean,
    backgroundColor: Color = MecTheme.colors.accent_primary,
    contentColor: Color = MecTheme.colors.white,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(all = 16.dp),
        shape = MaterialTheme.shapes.large,
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
    ) {
        if (text != null) {
            Text(
                text = text,
                style = MecTheme.typography.button.semibold,
            )
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
