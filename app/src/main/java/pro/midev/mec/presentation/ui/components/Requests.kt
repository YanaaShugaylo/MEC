package pro.midev.mec.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.enum.StatusRequests
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun RequestBase(
    imageId: Int = R.drawable.rectangle_207,
    status: StatusRequests,

    ) {
    Column(
        modifier = Modifier
            .width(238.dp)
            .height(184.dp)
            .background(color = MecTheme.colors.bg_primary),
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
            text = "data",
            color = MecTheme.colors.accent_primary,
            style = MecTheme.typography.button.semibold
        )
        Divider(
            color = MecTheme.colors.bg_secondary, modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(112.dp)
                .padding(top = 16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp),
                painter = painterResource(imageId),
                tint = Color.Unspecified,
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 16.dp, end = 0.dp)
            ) {
                Text(
                    text = "Title", style = MecTheme.typography.body_1.semibold, modifier = Modifier
                        .padding(start = 0.dp, top = 8.dp, end = 0.dp, bottom = 8.dp)
                )
                Text(
                    text = "№ 0101201012",
                    style = MecTheme.typography.caption.regular,
                    color = MecTheme.colors.text_tertiary,
                )
            }

        }
        Divider(
            color = MecTheme.colors.bg_secondary, modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(
                    when (status) {
                        StatusRequests.STATUS -> MecTheme.colors.bg_primary
                        StatusRequests.SUCCESS -> MecTheme.colors.attention.copy(alpha = 0.3f)
                        StatusRequests.EDIT -> MecTheme.colors.success.copy(alpha = 0.3f)
                        StatusRequests.ERROR -> MecTheme.colors.error.copy(alpha = 0.3f)
                        StatusRequests.WARNING -> MecTheme.colors.info.copy(alpha = 0.3f)
                    }
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp),
            ) {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    painter = when (status) {
                        StatusRequests.STATUS -> painterResource(R.drawable.icon_loading)
                        StatusRequests.SUCCESS -> painterResource(R.drawable.icon_warning)
                        StatusRequests.EDIT -> painterResource(R.drawable.icon_success)
                        StatusRequests.ERROR -> painterResource(R.drawable.icon_error)
                        StatusRequests.WARNING -> painterResource(R.drawable.icon_edit)
                    },
                    tint = Color.Unspecified,
                    contentDescription = ""
                )
                Text(
                    text = when (status) {
                        StatusRequests.STATUS -> "Статус"
                        StatusRequests.SUCCESS -> "Ошибка"
                        StatusRequests.EDIT -> "Успех"
                        StatusRequests.ERROR -> "Отказ"
                        StatusRequests.WARNING -> "Черновик"
                    },
                    style = MecTheme.typography.caption.semibold,
                    modifier = Modifier
                        .padding(start = 8.dp, top = 3.dp, end = 0.dp),
                    color = when (status) {
                        StatusRequests.STATUS -> MecTheme.colors.text_tertiary
                        StatusRequests.SUCCESS -> MecTheme.colors.attention
                        StatusRequests.EDIT -> MecTheme.colors.success
                        StatusRequests.ERROR -> MecTheme.colors.error
                        StatusRequests.WARNING -> MecTheme.colors.info
                    }
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true, widthDp = 800)
private fun RequestPreview() {
    MecTheme {
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(Modifier.padding(all = 24.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
                RequestBase(status = StatusRequests.STATUS)
                RequestBase(status = StatusRequests.ERROR)
                RequestBase(status = StatusRequests.WARNING)
            }
            Column(Modifier.padding(all = 24.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
                RequestBase(status = StatusRequests.EDIT)
                RequestBase(status = StatusRequests.SUCCESS)
            }
        }
    }
}
