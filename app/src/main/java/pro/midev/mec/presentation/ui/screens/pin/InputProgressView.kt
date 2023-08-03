package pro.midev.mec.presentation.ui.screens.pin

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pro.midev.mec.presentation.ui.style.MecTheme
import pro.midev.mec.presentation.ui.utils.LaunchEffectTrigger
import pro.midev.mec.presentation.ui.utils.dpToPx


@Composable
fun InputProgressView(
    value: String,
    dotSize: Dp,
    dotsCount: Int,
    dotsSpace: Dp,
    modifier: Modifier = Modifier,
    errorTrigger: LaunchEffectTrigger? = null
) {
    val lastIndex = value.lastIndex

    val offsetAnimatable = remember { Animatable(0F) }

    LaunchedEffect(errorTrigger) {
        if (errorTrigger != null) {
            offsetAnimatable.animateTo(
                targetValue = 20f,
                animationSpec = tween(100)
            )

            offsetAnimatable.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = 0.4f,
                    stiffness = Spring.StiffnessHigh
                )
            )
        }
    }

    LazyRow(
        modifier = modifier.offset(x = offsetAnimatable.value.dp),
        horizontalArrangement = Arrangement.spacedBy(dotsSpace)
    ) {
        items(dotsCount) { i ->
            when {
                i < lastIndex + 1 -> InputProgressDot(size = dotSize, style = DotStyle.FILLED)
                else -> InputProgressDot(size = dotSize, style = DotStyle.EMPTY)
            }
        }
    }
}

@Composable
private fun InputProgressDot(
    size: Dp,
    style: DotStyle,
    animatable: Boolean = true
) {
    val emptyColor = MecTheme.colors.accent_secondary
    val filledColor = MecTheme.colors.accent_primary
    val radiusWithStroke = size.dpToPx() / 2

    val offsetAnimatable = remember { Animatable(0f) }

    if (style == DotStyle.FILLED && animatable) {
        LaunchedEffect(Unit) {
            offsetAnimatable.animateTo(
                targetValue = 10f,
                animationSpec = tween(200)
            )

            offsetAnimatable.animateTo(
                targetValue = 0f,
                animationSpec = spring(
                    dampingRatio = 0.4f,
                    stiffness = Spring.StiffnessMedium
                )
            )
        }
    }

    Canvas(
        modifier = Modifier
            // Почему-то 1px обрезается
            .padding(horizontal = 1.dp)
            .offset(y = -offsetAnimatable.value.dp)
            .size(size),
        onDraw = {
            when (style) {
                DotStyle.EMPTY -> {
                    drawCircle(
                        radius = radiusWithStroke,
                        color = emptyColor
                    )
                }

                DotStyle.FILLED -> {
                    drawCircle(
                        radius = radiusWithStroke,
                        color = filledColor,
                    )
                }
            }
        }
    )


}

private enum class DotStyle {
    FILLED, EMPTY
}

@Composable
@Preview(showBackground = true)
private fun InputProgressViewPreview() {
    MecTheme {
        Column(
            modifier = Modifier.padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            InputProgressDot(size = 12.dp, style = DotStyle.EMPTY)
            InputProgressDot(size = 12.dp, style = DotStyle.FILLED)
            InputProgressView(value = "", dotSize = 12.dp, dotsCount = 6, dotsSpace = 12.dp)
            InputProgressView(value = "123456", dotSize = 12.dp, dotsCount = 6, dotsSpace = 12.dp)
            InputProgressView(value = "1234", dotSize = 12.dp, dotsCount = 6, dotsSpace = 12.dp)
        }
    }
}
