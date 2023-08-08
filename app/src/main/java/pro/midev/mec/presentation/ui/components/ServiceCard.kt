package pro.midev.mec.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun MecServiceCard(

)
{
    val mainColor: Color by animateColorAsState(
        MecTheme.colors.accent_primary
    )
    val blackColor: Color by animateColorAsState(
        MecTheme.colors.black
    )
    Box(
        modifier = Modifier
            .padding(16.dp)
            .size(156.dp, 156.dp)
            .background(Color.White)
            .padding(top = 8.dp, start = 8.dp)
    )
    {
        Box(
            contentAlignment = Alignment.TopStart,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Blue)
        ){
            Column( modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                )
                {
                    Text("00",
                        style = MecTheme.typography.h5.semibold,
                        color = mainColor,
                        modifier = Modifier.padding(end = 4.dp)
                    )
                    Text("Name",
                        style = MecTheme.typography.overline.semibold,
                        color = blackColor,
                        modifier = Modifier.padding(top = 3.dp, end = 8.dp)
                    )
                }
                Box(contentAlignment = Alignment.BottomEnd, modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)) {
                    Image(
                        painterResource(id = R.drawable.img_card),
                        contentDescription = "Dog Image",
                        modifier = Modifier.padding(start = 30.dp)
                            .size(136.dp, 136.dp))
                }

            }

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