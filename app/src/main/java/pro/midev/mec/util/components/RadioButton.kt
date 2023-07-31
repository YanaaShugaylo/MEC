package pro.midev.mec.util.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Checkbox
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
fun MecCheckbox(
    isChecked: Boolean,
    onCheck: (isChecked: Boolean) -> Unit
) {

    val bgColor: Color by animateColorAsState(
        MecTheme.colors.accent_primary
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

    Box(
        modifier = Modifier
            .padding(30.dp)
            .clip(CircleShape)
            .size(width = 20.dp, height = 20.dp)
            .background(bgColor)
            .padding(2.dp)
            .clip(CircleShape)
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Box( modifier = Modifier
            .clip(CircleShape)
            .size(width = 14.dp, height = 14.dp)
            .background(rectangleColor)
        )
    }
}



@Composable
@Preview
private fun RadioButtonPreview() {
    MecTheme {
        MecCheckbox(
            isChecked = false,
            onCheck = {}
        )
    }
}