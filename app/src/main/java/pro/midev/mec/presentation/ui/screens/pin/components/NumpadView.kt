package pro.midev.mec.presentation.ui.screens.pin.components

import android.view.MotionEvent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
fun NumpadView(
    onInput: (value: String) -> Unit = {},
    @DrawableRes removeIcon: Int?,
    onRemove: () -> Unit = {},
    modifier: Modifier = Modifier,
    actionTextColor: Color? = null,
    actionText: String? = null,
    onActionClick: Unit? = null
) {

    val rowsSpacing = 24.dp

    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = rowsSpacing),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            NumpadTextButton(value = "1", onClick = onInput)
            NumpadTextButton(value = "2", onClick = onInput)
            NumpadTextButton(value = "3", onClick = onInput)
        }

        Row(
            modifier = Modifier
                .padding(bottom = rowsSpacing),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            NumpadTextButton(value = "4", onClick = onInput)
            NumpadTextButton(value = "5", onClick = onInput)
            NumpadTextButton(value = "6", onClick = onInput)
        }

        Row(
            modifier = Modifier
                .padding(bottom = rowsSpacing),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            NumpadTextButton(value = "7", onClick = onInput)
            NumpadTextButton(value = "8", onClick = onInput)
            NumpadTextButton(value = "9", onClick = onInput)
        }

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            onActionClick?.let {
                NumpadIconButton(icon = R.drawable.ic_finger_print, onClick = { onActionClick }, size = 64.dp)
            } ?: NumpadEmptyButton()
            Spacer(Modifier.width(width = 32.dp))
            NumpadTextButton(value = "0", onClick = onInput)
            Spacer(Modifier.width(width = 40.dp))
            NumpadIconButton(icon = R.drawable.ic_x, onClick = onRemove, size = 48.dp)
        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun NumpadTextButton(
    value: String,
    size: Dp = 64.dp,
    onClick: (value: String) -> Unit,
    paddingStart: Dp = 0.dp
) {

    val color = remember { mutableStateOf(Color(0xFFF4EBFC)) } // не придумал по другому

    TextButton(
        onClick = {

        },
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = color.value,
            contentColor = MecTheme.colors.text_primary
        ),
        modifier = Modifier
            .size(size)
            .clip(RectangleShape)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        color.value = Color(0xFF663399)
                    }

                    MotionEvent.ACTION_UP -> {
                        onClick(value)
                        color.value = Color(0xFFF4EBFC)
                    }
                }
                true
            }
            ,
        shape = RectangleShape,
    ) {
        Text(
            text = value,
            style = MecTheme.typography.h5.regular
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun NumpadIconButton(
    @DrawableRes icon: Int,
    onClick: () -> Unit,
    size: Dp,
) {

    val color = remember { mutableStateOf(Color(0xFFF4EBFC)) } // не придумал по другому

    Button(
        modifier = Modifier
            .size(size)
            .clip(RectangleShape)
            .pointerInteropFilter {
                when (it.action) {
                    MotionEvent.ACTION_DOWN -> {
                        color.value = Color(0xFF663399)
                    }

                    MotionEvent.ACTION_UP -> {
                        color.value = Color(0xFFF4EBFC)
                        onClick()
                    }
                }
                true
            },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color.value,
            contentColor = MecTheme.colors.text_primary
        ),
        elevation = null,
        onClick = {}
    ) {
        Icon(
            painter = painterResource(icon),
            contentDescription = "action"
        )
    }
}

@Composable
private fun NumpadEmptyButton() {
    Canvas(modifier = Modifier.size(64.dp), onDraw = { })
}


@Composable
@Preview(showBackground = true)
private fun PreviewNomepad() {
    MecTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NumpadTextButton(value = "5", onClick = {})
            NumpadTextButton(value = "1", onClick = {}, size = 48.dp)
            NumpadIconButton(icon = R.drawable.ic_x, onClick = { /*TODO*/ }, size = 48.dp)
            NumpadIconButton(icon = R.drawable.ic_finger_print, onClick = { /*TODO*/ }, size = 64.dp)
            NumpadView(removeIcon = R.drawable.ic_x)
        }

    }
}