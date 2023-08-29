package pro.midev.mec.presentation.ui.screens.services.service_detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import pro.midev.mec.presentation.ui.components.TextTitleToolbar
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun ServiceDetailView(
    state: ServiceDetailState,
    eventConsumer: (ServiceDetailEvent) -> Unit
) {

    val listState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MecTheme.colors.white)
    )
    {

        TextTitleToolbar(hasNavigationIcon = true, onBackPressed = {})


        LazyColumn(state = listState, modifier = Modifier.padding(horizontal = 16.dp)) {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(state.service.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(280.dp)
                        .padding(end = 31.dp, start = 32.dp, top = 8.dp)
                )
            }

            item { // заголовок услуги
                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = state.service.title,
                    style = MecTheme.typography.h5.semibold,
                    color = MecTheme.colors.accent_primary,
                )
            }

//            item {
//                Text(text = state.service.te)
//            }

        }
    }
}


@Preview
@Composable
private fun ServiceDetailViewPreview() {
    MecTheme {
        ServiceDetailView(
            state = ServiceDetailState(),
            eventConsumer = {}
        )
    }
}