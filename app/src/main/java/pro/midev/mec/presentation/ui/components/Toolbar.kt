package pro.midev.mec.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ProvideTextStyle
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.contentColorFor
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
fun TextTitleToolbar(
    title: String = "",
    largeToolbar: Boolean = false,
    onBackPressed: (() -> Unit)? = null,
    actionsStart: @Composable () -> Unit = {},
    actionsEnd: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MecTheme.colors.white,
    hasNavigationIcon: Boolean = false
) {
    TopAppBarStartedTitle(
        largeToolbar = largeToolbar,
        title = {
            Text(
                text = title,
                style = if (largeToolbar) MecTheme.typography.h5.regular else MecTheme.typography.subtitle_1.semibold
            )
        },
        navigationIcon = {
            onBackPressed?.let {
                IconButton(onClick = { it.invoke() }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_back),
                        contentDescription = "Назад"
                    )
                }
            } ?: run {
                actionsStart()
            }
        },
        backgroundColor = backgroundColor,
        contentColor = MecTheme.colors.black,
        elevation = 0.dp,
        actions = actionsEnd,
        hasNavigationIcon = hasNavigationIcon
    )
}

@Composable
private fun TopAppBarStartedTitle(
    hasNavigationIcon: Boolean,
    title: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    largeToolbar: Boolean = false,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {},
    backgroundColor: Color = MaterialTheme.colors.primarySurface,
    contentColor: Color = contentColorFor(backgroundColor),
    elevation: Dp = AppBarDefaults.TopAppBarElevation
) {
    AppBar(
        largeToolbar,
        backgroundColor,
        contentColor,
        elevation,
        AppBarDefaults.ContentPadding,
        RectangleShape,
        modifier
    ) {
        Box(modifier = Modifier.fillMaxHeight()) {
            Row() {
                if (navigationIcon != null && hasNavigationIcon) {
                    Row(
                        TitleIconModifier,
                        verticalAlignment = if (largeToolbar) Alignment.Top else Alignment.CenterVertically
                    ) {
                        CompositionLocalProvider(
                            LocalContentAlpha provides ContentAlpha.high,
                            content = navigationIcon
                        )
                    }
                } else {
                    Spacer(modifier = Modifier.width(24.dp))
                }

                Row(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .padding(
                            end = if (navigationIcon != null)
                                72.dp - AppBarHorizontalPadding
                            else
                                0.dp,
                            bottom = if (largeToolbar) 20.dp else 0.dp
                        ),
                    verticalAlignment = if (largeToolbar) Alignment.Bottom else Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    ProvideTextStyle(value = if (largeToolbar) MecTheme.typography.subtitle_1.semibold else MecTheme.typography.h5.regular) {
                        Box {
                            CompositionLocalProvider(
                                LocalContentAlpha provides ContentAlpha.high,
                                content = title
                            )
                        }
                    }
                }
            }
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Row(
                    Modifier
                        .fillMaxHeight()
                        .align(Alignment.CenterEnd),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = if (largeToolbar) Alignment.Top else Alignment.CenterVertically,
                    content = actions
                )
            }
        }
    }
}

@Composable
private fun AppBar(
    largeToolbar: Boolean,
    backgroundColor: Color,
    contentColor: Color,
    elevation: Dp,
    contentPadding: PaddingValues,
    shape: Shape,
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    Surface(
        color = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
        shape = shape,
        modifier = modifier
    ) {
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(contentPadding)
                    .height(if (largeToolbar) LargeBarHeight else AppBarHeight),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                content = content
            )
        }
    }
}

private val AppBarHeight = 56.dp
private val LargeBarHeight = 128.dp
private val AppBarHorizontalPadding = 4.dp
private val TitleInsetWithoutIcon = Modifier.width(16.dp - AppBarHorizontalPadding) // 12 отступ с боку
private val TitleIconModifier = Modifier
    .fillMaxHeight()
    .width(72.dp - AppBarHorizontalPadding)


@Composable
@Preview(showBackground = true)
private fun ToolbarPreview() {
    MecTheme {
        Column(modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(24.dp)) {
            TextTitleToolbar(
                title = "Title",
                onBackPressed = {},
                hasNavigationIcon = true
            ) // Icon-title-icons
            TextTitleToolbar(title = "Title", hasNavigationIcon = false, onBackPressed = null, actionsEnd = {
                Row {
                    Image(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 24.dp)
                            .clickable { {} }
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 24.dp)
                            .clickable { {} }
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_star),
                        contentDescription = "",
                        modifier = Modifier
                            .padding(end = 16.dp)
                            .clickable { {} }
                    )
                }

            }) // title-icons

            TextTitleToolbar(
                onBackPressed = {},
                hasNavigationIcon = true,
                largeToolbar = true,
                title = "Title",
                actionsEnd = {
                    Row(modifier = Modifier.padding(top = 16.dp)) {
                        Image(
                            painter = painterResource(R.drawable.ic_star),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 24.dp)
                                .clickable { {} }
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_star),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 24.dp)
                                .clickable { {} }
                        )
                        Image(
                            painter = painterResource(R.drawable.ic_star),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(end = 16.dp)
                                .clickable { {} }
                        )
                    }

                }) // title-icons
        }

    }
}

