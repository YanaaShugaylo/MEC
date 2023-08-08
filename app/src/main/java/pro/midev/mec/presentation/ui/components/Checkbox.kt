package pro.midev.mec.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun MecCheckBoxMark(
    isChecked: Boolean,
    onCheck: (isChecked: Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onCheck(!isChecked) }
    ) {
        if (!isChecked) {
            MecCheckBoxInactive()
        } else {
            val bgColor: Color by animateColorAsState(
                    MecTheme.colors.accent_primary
            )
            val rectangleColor: Color by animateColorAsState(
                    MecTheme.colors.accent_primary
            )
            Box(
                modifier = Modifier
                    .padding(30.dp)
                    .clip(RectangleShape)
                    .size(width = 24.dp, height = 24.dp)
                    .background(bgColor)
                    .padding(2.dp)
                    .clip(RectangleShape)
                    .background(rectangleColor),
                contentAlignment = Alignment.Center
            ) {

                Icon(
                    painter = painterResource(id = R.drawable.ic_checkbox_mark),
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(width = 14.4.dp, height = 10.6.dp)
                )

            }
        }
    }
}

@Composable
fun MecCheckBoxSquare(
    isChecked: Boolean,
    onCheck: (isChecked: Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onCheck(!isChecked) }
    ) {
        if (!isChecked) {
            MecCheckBoxInactive()
        } else {
            val bgColor: Color by animateColorAsState(
                    MecTheme.colors.accent_primary
            )
            val rectangleColor: Color by animateColorAsState(
                    MecTheme.colors.accent_primary
            )
            Box(
                modifier = Modifier
                    .padding(30.dp)
                    .clip(RectangleShape)
                    .size(width = 24.dp, height = 24.dp)
                    .background(bgColor)
                    .padding(2.dp)
                    .clip(RectangleShape)
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Box( modifier = Modifier
                    .clip(RectangleShape)
                    .size(width = 14.dp, height = 14.dp)
                    .background(rectangleColor)
                )
            }
        }
    }
}

@Composable
private fun MecCheckBoxInactive() {
    val unactiveColor: Color by animateColorAsState(
            MecTheme.colors.text_tertiary
    )
    val whiteColor: Color by animateColorAsState(
            MecTheme.colors.white
    )
    Box(
        modifier = Modifier
            .padding(30.dp)
            .clip(RectangleShape)
            .size(width = 24.dp, height = 24.dp)
            .background(unactiveColor)
            .padding(2.dp)
            .clip(RectangleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box( modifier = Modifier
            .clip(RectangleShape)
            .size(width = 14.dp, height = 14.dp)
            .background(whiteColor)
        )
    }

}
@Composable
@Preview
private fun CheckboxPreview() {
    MecTheme {
        MecCheckBoxMark(isChecked = true, onCheck = {})
        MecCheckBoxMark(isChecked = false, onCheck = {})

        MecCheckBoxSquare(isChecked = true, onCheck = {})
        MecCheckBoxSquare(isChecked = false, onCheck = {})
    }
}
