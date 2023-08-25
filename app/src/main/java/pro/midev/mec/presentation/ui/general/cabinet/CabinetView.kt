package pro.midev.mec.presentation.ui.general.cabinet

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.enum.StatusRequests
import pro.midev.mec.presentation.model.human.AccountHuman
import pro.midev.mec.presentation.model.human.RequestHuman
import pro.midev.mec.presentation.ui.components.ButtonPrimary
import pro.midev.mec.presentation.ui.components.RequestBase
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun CabinetView(
    state: CabinetState
) {
    val lazyState = rememberLazyListState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
                .background(MecTheme.colors.white)
        ) {
            Text(
                text = state.accountHuman.lastName + " " + state.accountHuman.firstName + " " + state.accountHuman.middleName,
                style = MecTheme.typography.h5.semibold,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
                color = MecTheme.colors.text_primary
            )
            Text(
                text = stringResource(R.string.title_org_inn) + " " + state.accountHuman.orgInn,
                style = MecTheme.typography.h6.regular,
                color = MecTheme.colors.text_secondary,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            )
            ButtonPrimary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
                onClick = { },
                text = stringResource(R.string.btn_next),

                )
        }
        Text(
            text = stringResource(R.string.title_requests),
            style = MecTheme.typography.h6.semibold,
            color = MecTheme.colors.text_primary,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        )
        if (state.requestHumanList.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
                    .background(MecTheme.colors.white)
            ) {
                Text(
                    text = stringResource(R.string.title_no_request),
                    style = MecTheme.typography.h5.semibold,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
                    color = MecTheme.colors.text_primary,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = stringResource(R.string.subtitle_no_request),
                    style = MecTheme.typography.h6.regular,
                    color = MecTheme.colors.text_secondary,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                    textAlign = TextAlign.Center
                )
                ButtonPrimary(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
                    onClick = { },
                    text = stringResource(R.string.btn_no_request),

                    )
            }
        } else {
            LazyColumn(
                state = lazyState,
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                itemsIndexed(items = state.requestHumanList) { index, item ->
                    RequestBase(
                        status = StatusRequests.STATUS,
                        date = item.createdAt!!,
                        number = stringResource(R.string.title_num) + " " + item.num,
                        title = item.name!!,
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 31.dp, top = 48.dp)
                .background(MecTheme.colors.white)
                .clickable { },
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(MecTheme.colors.white)
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_question_often),
                    tint = Color.Unspecified,
                    contentDescription = ""
                )
                Text(
                    text = stringResource(R.string.btn_question),
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 6.dp, bottom = 6.dp)
                        .weight(1f),
                    style = MecTheme.typography.body_2.semibold
                )
                Icon(
                    painter = painterResource(R.drawable.ic_next),
                    contentDescription = "",
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .weight(0.05f),
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
private fun CabinetViewPreview() {
    MecTheme {
        CabinetView(
            CabinetState(
                "", mutableListOf(
                    RequestHuman(
                        "123",
                        "123",
                        "",
                        "bnjdfkgbfngbjfgjbngfkjbfgjn",
                        "",
                        mutableListOf(),
                        "1.01.2023",
                        "статус"
                    ),
                    RequestHuman(
                        "123",
                        "123",
                        "",
                        "bgnfbkjfgnlbkfgbnkfglbfgnbklfgbnfgkl nfjbvkfgnbjgfbgnfk",
                        "",
                        mutableListOf(),
                        "1.01.2023",
                        "1.01.2023"
                    ),
                    RequestHuman("123", "123", "", "", "", mutableListOf(), "1.01.2023", "статус"),
                    RequestHuman("123", "123", "", "", "", mutableListOf(), "1.01.2023", "1.01.2023")
                ), AccountHuman.getDefault()
            )
        )
    }
}
