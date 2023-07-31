package pro.midev.mec.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
fun MecCheckbox(
    isChecked: Boolean,
    onCheck: (isChecked: Boolean) -> Unit
) {

    //Это моя ветка с радио кнопками

    val bgColor: Color by animateColorAsState(
        if(isChecked)
            MecTheme.colors.accent_primary
        else
            MecTheme.colors.text_tertiary
    )
    val rectangleColor: Color by animateColorAsState(
        if(isChecked)
            MecTheme.colors.accent_primary
        else
            MecTheme.colors.white
    )
    val borderColor: Color by animateColorAsState(
        MecTheme.colors.text_tertiary
    )

    Column {
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

            // Icon(imageVector = Icons.Default.Check, contentDescription = "")
            Icon(
                //change icon
                painter = painterResource(id = R.drawable.chat_item_menu),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.fillMaxSize()
            )

        }
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


@Composable
@Preview
private fun CheckboxPreview() {
    MecTheme {
        MecCheckbox(
            isChecked = true,
            onCheck = {}
        )
    }
}
