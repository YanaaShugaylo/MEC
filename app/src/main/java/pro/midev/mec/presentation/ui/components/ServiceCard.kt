package pro.midev.mec.presentation.ui.components

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun MecServiceCard(
    title: String,
    photo: String,
) {

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
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                )
                {
                    Text(
                        text = title,
                        style = MecTheme.typography.overline.semibold,
                        color = MecTheme.colors.text_primary,
                        modifier = Modifier.padding(top = 3.dp, end = 8.dp)
                    )
                }
                Box(
                    contentAlignment = Alignment.BottomEnd, modifier = Modifier
                        .fillMaxSize()
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(photo)
                            .crossfade(true)
                            .build(),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(start = 30.dp)
                            .size(136.dp, 136.dp)
                    )
                }

            }

        }
    }
}


@Preview
@Composable
private fun MecServiceCardPreview() {

    MecTheme {
        MecServiceCard(
            title = "Главная",
            photo = "https://mec.htmlup.ru/storage/2022/08/18/18d9a2fb3307b975f26771fac16fddffe476151b.png"
        )
    }

}