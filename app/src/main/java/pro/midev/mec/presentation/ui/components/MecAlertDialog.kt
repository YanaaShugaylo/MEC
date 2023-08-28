package pro.midev.mec.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun SurfAlertDialog(
    title: String,
    description: String? = null,
    positiveButtonText: String? = null,
    positiveButtonColor: Color = MecTheme.colors.error,
    positiveButtonOnClick: () -> Unit = {},
    negativeButtonText: String? = null,
    negativeButtonColor: Color = MecTheme.colors.accent_primary,
    negativeButtonOnClick: () -> Unit = {},
    onDismiss: () -> Unit = {}
) {
    AlertDialog(
        modifier = Modifier.customDialogModifier(CustomDialogPosition.BOTTOM),
        onDismissRequest = { onDismiss() },
        title = {
            Text(
                text = title,
                style = MecTheme.typography.subtitle_1.semibold,
                color = MecTheme.colors.accent_primary
            )
        },
        text = {
            description?.let {
                Text(
                    text = description,
                    style = MecTheme.typography.subtitle_1.regular,
                    color = MecTheme.colors.success
                )
            }
        },
        confirmButton = {
            positiveButtonText?.let {
                TextButton(
                    onClick = {
                        onDismiss()
                        positiveButtonOnClick()
                    }
                ) {
                    Text(
                        text = positiveButtonText.toUpperCase(),
                        style = MecTheme.typography.subtitle_1.semibold,
                        color = positiveButtonColor
                    )
                }
            }
        },
        dismissButton = {
            negativeButtonText?.let {
                TextButton(
                    onClick = {
                        onDismiss()
                        negativeButtonOnClick()
                    }
                ) {
                    Text(
                        text = negativeButtonText.toUpperCase(),
                        style = MecTheme.typography.subtitle_1.regular,
                        color = negativeButtonColor
                    )
                }
            }
        }
    )

}

@Composable
@Preview(showBackground = true)
private fun SurfAlertDialogPreview() {
    MecTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            SurfAlertDialog(
                title = "Код пароль изменен",
                description = "Description",
                positiveButtonText = "Accept",
                positiveButtonColor = MecTheme.colors.error,
                negativeButtonText = "Decline",
                negativeButtonColor = MecTheme.colors.text_secondary
            )
        }
    }
}

enum class CustomDialogPosition {
    BOTTOM, TOP
}

fun Modifier.customDialogModifier(pos: CustomDialogPosition) = layout { measurable, constraints ->

    val placeable = measurable.measure(constraints);
    layout(constraints.maxWidth, constraints.maxHeight){
        when(pos) {
            CustomDialogPosition.BOTTOM -> {
                placeable.place(0, constraints.maxHeight - placeable.height, 10f)
            }
            CustomDialogPosition.TOP -> {
                placeable.place(0,0,10f)
            }
        }
    }
}
