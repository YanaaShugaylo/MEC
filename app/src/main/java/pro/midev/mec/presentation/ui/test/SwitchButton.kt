package pro.midev.mec.presentation.ui.test

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.SwitchColors
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
    fun MecSwitch(
        isChecked: Boolean,
        onCheck: (isChecked: Boolean) -> Unit,
        colors: SwitchColors = SwitchDefaults.colors()
    ) {

        val borderColor: Color by animateColorAsState(
            if (isChecked)
                MecTheme.colors.accent_primary
            else
                MecTheme.colors.text_tertiary
        )

        val trackColor: Color by animateColorAsState(
            if (isChecked)
                MecTheme.colors.accent_primary
            else
                MecTheme.colors.text_tertiary
        )
        val thumbColor: Color by animateColorAsState(
            if (isChecked)
                MecTheme.colors.white
            else
                MecTheme.colors.white
        )

        val offset: Dp by animateDpAsState(
            targetValue = if (isChecked)
                26.dp // На рандом поставил
            else
                0.dp,
            animationSpec = spring(
                dampingRatio = 0.6f,
                stiffness = Spring.StiffnessLow
            )
        )

        Box(
            modifier = Modifier
                .background(
                    color = trackColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .size(
                    width = 57.dp,
                    height = 31.dp
                )
                .border(
                    width = 1.5.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(16.dp)
                )
                .clickable(
                    indication = null,
                    interactionSource = remember { MutableInteractionSource() }
                ) {
                    onCheck(!isChecked)
                }
                .padding(3.dp),
        ) {

            val trackRadius = 13.dp

            Canvas(
                modifier = Modifier
                    .fillMaxSize()
                ,
                onDraw = {
                    drawCircle(
                        color = thumbColor,
                        radius = trackRadius.toPx(),
                        center = Offset(
                            x = trackRadius.toPx() + offset.toPx(),
                            y = trackRadius.toPx()
                        )
                    )
                }
            )
        }
    }

    @Composable
    @Preview
    private fun SwitchPreview() {
        MecTheme {
            MecSwitch(
                isChecked = true,
                onCheck = {},
            )
        }
    }

