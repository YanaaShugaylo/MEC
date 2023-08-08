package pro.midev.mec.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun MecServiceCard(

)
{
    val mainColor: Color by animateColorAsState(
        MecTheme.colors.accent_primary
    )
    Box(
        modifier = Modifier
            .size(156.dp, 156.dp)
            .background(Color.White)
    )
    {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier.fillMaxSize()
        ){
            Text("00",
                style = TextStyle(fontSize = 24.sp),
                color = mainColor,
                fontFamily = FontFamily.Monospace,
            )
        }
    }
}


@Preview
@Composable
private fun MecServiceCardPreview()
{

    MecTheme {
        MecServiceCard()
    }

}