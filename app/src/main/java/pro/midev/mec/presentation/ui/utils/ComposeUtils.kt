package pro.midev.mec.presentation.ui.utils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun Int.pxToDp() = with(LocalDensity.current) { this@pxToDp.toDp() }

@Composable
fun Dp.dpToPx() = with(LocalDensity.current) { this@dpToPx.toPx() }

@Composable
fun TextUnit.toDp() = with(LocalDensity.current) { this@toDp.toDp() }

@Composable
fun TextUnit.toPx() = with(LocalDensity.current) { this@toPx.toPx() }


@Immutable
class LaunchEffectTrigger()
