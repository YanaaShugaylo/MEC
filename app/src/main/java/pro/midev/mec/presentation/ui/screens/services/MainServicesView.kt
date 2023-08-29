package pro.midev.mec.presentation.ui.screens.services

import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import pro.midev.mec.R
import pro.midev.mec.enum.TypeServices
import pro.midev.mec.presentation.ui.components.ButtonPrimary
import pro.midev.mec.presentation.ui.components.MecServiceCard
import pro.midev.mec.presentation.ui.components.TextFieldInput
import pro.midev.mec.presentation.ui.components.TextTitleCenteredToolbar
import pro.midev.mec.presentation.ui.style.MecTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainServicesView(
    state: MainServicesState,
    eventConsumer: (MainServicesEvent) -> Unit
) {

    val horizontalLazyListState = rememberLazyListState()
    val gridState = rememberLazyStaggeredGridState()


    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(MecTheme.colors.accent_primary) // установка цвета системного статус бара

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MecTheme.colors.white)
            .statusBarsPadding()
    ) {
        TextTitleCenteredToolbar(
            title = stringResource(id = R.string.services),
            backgroundColor = MecTheme.colors.accent_primary,
        )

        LazyRow(
            state = horizontalLazyListState, modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
        {
            item {
                TypeServices(
                    onClick = { eventConsumer(MainServicesEvent.ChangeTypeServices(TypeServices.FINANCES)) },
                    text = R.string.services_finances,
                    isSelected = state.typeService == TypeServices.FINANCES
                )
            }
            item {
                TypeServices(
                    onClick = { eventConsumer(MainServicesEvent.ChangeTypeServices(TypeServices.UNFINANCES)) },
                    text = R.string.services_unfinances,
                    isSelected = state.typeService == TypeServices.UNFINANCES
                )
            }
        }

        AnimatedVisibility(state.typeService == TypeServices.FINANCES) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(color = MecTheme.colors.white)
                    .padding(start = 15.dp, end = 17.dp, top = 32.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.pick_up_subsidy),
                    color = MecTheme.colors.text_primary,
                    style = MecTheme.typography.h6.semibold,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                TextFieldInput(
                    label = stringResource(id = R.string.inn),
                    iconEnd = if (!state.inn.isNullOrBlank()) R.drawable.ic_cancel else null,
                    text = state.inn ?: "",
                    onValueChange = { eventConsumer(MainServicesEvent.ChangeInn(it)) },
                    placeholder = stringResource(id = R.string.inn),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    onEndIconClick = { eventConsumer(MainServicesEvent.RemoveInn) }
                )

                ButtonPrimary(
                    onClick = { /*TODO*/ },
                    text = stringResource(id = R.string.pick_up),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                )
            }
        }

        Text(
            text = stringResource(id = R.string.all_services),
            color = MecTheme.colors.text_primary,
            style = MecTheme.typography.h5.semibold,
            modifier = Modifier.padding(start = 16.dp, top = 56.dp, bottom = 16.dp)
        )
        if (!state.isLoading) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(horizontal = 16.dp),
                state = gridState,
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalItemSpacing = 16.dp
            ) {
                itemsIndexed(items = state.services.filter { it.type == state.typeService }) { index, service ->
                    MecServiceCard(title = service.previewTitle, photo = service.previewImage)
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .zIndex(2f)
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(53.dp), color = MecTheme.colors.accent_primary, strokeWidth = 6.dp
                )
            }
        }
    }
}

@Composable
fun TypeServices(
    @StringRes text: Int,
    isSelected: Boolean = false,
    onClick: () -> Unit,
    isLastPosition: Boolean = false
) {
    Box(
        modifier = Modifier
            .padding(start = 16.dp, end = if (isLastPosition) 16.dp else 0.dp)
            .background(color = if (isSelected) MecTheme.colors.accent_primary else MecTheme.colors.white)
            .border(
                width = if (!isSelected) 1.dp else 0.dp,
                shape = RectangleShape,
                color = if (!isSelected) MecTheme.colors.bg_secondary else MecTheme.colors.accent_primary
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = {
                onClick()
            })
    ) {
        Text(
            text = stringResource(id = text),
            style = if (isSelected) MecTheme.typography.subtitle_1.semibold else MecTheme.typography.subtitle_1.regular,
            color = if (isSelected) MecTheme.colors.white else MecTheme.colors.text_tertiary
        )
    }
}

@Composable
@Preview
private fun MainServicesViewPreview() {
    MecTheme {
        MainServicesView(state = MainServicesState(),
            eventConsumer = {})
    }
}