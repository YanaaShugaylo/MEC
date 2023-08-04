package pro.midev.mec.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.enum.StatusRequests
import pro.midev.mec.presentation.ui.style.MecTheme
import java.text.DateFormat

@Composable
fun RequestBase(
    imageId: Int = R.drawable.img_cart_requests,
    status: StatusRequests,
    number: String,
    date: String,
    title: String
) {
    Column(
        modifier = Modifier
            .background(color = MecTheme.colors.bg_primary),
    ) {
        Text(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp, bottom = 8.dp),
            text = date,
            color = MecTheme.colors.accent_primary,
            style = MecTheme.typography.button.semibold
        )
        Divider(
            color = MecTheme.colors.bg_secondary, modifier = Modifier
                .height(1.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Image(
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp),
                painter = painterResource(imageId),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp, top = 16.dp, end = 0.dp)
            ) {
                Text(
                    text = title, style = MecTheme.typography.body_1.semibold, modifier = Modifier
                        .padding(vertical = 8.dp)
                )
                Text(
                    text = number,
                    style = MecTheme.typography.caption.regular,
                    color = MecTheme.colors.text_tertiary,
                )
            }
        }
        Divider(
            color = MecTheme.colors.bg_secondary, modifier = Modifier
                .height(1.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
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
                    .padding(start = 16.dp, top = 8.dp, end = 0.dp, bottom = 8.dp),
            ) {
                Icon(
                    modifier = Modifier
                        .width(24.dp)
                        .height(24.dp),
                    painter = when (status) {
                        StatusRequests.STATUS -> painterResource(R.drawable.ic_loading_requests)
                        StatusRequests.SUCCESS -> painterResource(R.drawable.ic_warning_requests)
                        StatusRequests.EDIT -> painterResource(R.drawable.ic_success_requests)
                        StatusRequests.ERROR -> painterResource(R.drawable.ic_error_requests)
                        StatusRequests.WARNING -> painterResource(R.drawable.ic_edit_requests)
                    },
                    tint = Color.Unspecified,
                    contentDescription = ""
                )
                Text(
                    text = when (status) {
                        StatusRequests.STATUS -> stringResource(R.string.status_status)
                        StatusRequests.SUCCESS -> stringResource(R.string.success_status)
                        StatusRequests.EDIT -> stringResource(R.string.edit_status)
                        StatusRequests.ERROR -> stringResource(R.string.error_status)
                        StatusRequests.WARNING -> stringResource(R.string.warning_status)
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
@Preview(showBackground = true, widthDp = 900, heightDp = 900)
private fun RequestPreview() {
    MecTheme {
        Row() {
            Column(
                Modifier
                    .padding(all = 24.dp)
                    .height(900.dp)
                    .width(300.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                RequestBase(status = StatusRequests.STATUS, number = "№ 1234", date = "1.01.2023", title = "Title")
                RequestBase(status = StatusRequests.ERROR, number = "№ 1234", date = "1.01.2023", title = "Title")
                RequestBase(status = StatusRequests.WARNING, number = "№ 1234", date = "1.01.2023", title = "Title")

            }
            Column(
                Modifier
                    .padding(all = 24.dp)
                    .height(900.dp)
                    .width(300.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                RequestBase(status = StatusRequests.EDIT, number = "№ 1234", date = "1.01.2023", title = "Title")
                RequestBase(status = StatusRequests.SUCCESS, number = "№ 1234", date = "1.01.2023", title = "Title")
            }
        }
    }
}
