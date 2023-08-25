package pro.midev.mec.presentation.ui.general.profile

import android.annotation.SuppressLint
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.ProgressIndicatorDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.components.ButtonOutlined
import pro.midev.mec.presentation.ui.components.ButtonPrimary
import pro.midev.mec.presentation.ui.components.TextFieldInput
import pro.midev.mec.presentation.ui.style.MecTheme

@Composable
fun ProfileView(/*state: ProfileState*/) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MecTheme.colors.white)
            .statusBarsPadding()
    ) {
        LazyColumn() {
            item {
                StatusExportBlock()
            }
            item {
                RouterBlock()
            }
            item {
                DigitalSignatureBlock()
            }
            item {
                Text(
                    text = stringResource(R.string.title_profile),
                    style = MecTheme.typography.h6.semibold,
                    color = MecTheme.colors.text_primary,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 56.dp, bottom = 8.dp)
                )
                PersonalizationDataBlock()
            }
            item {

                Text(
                    //прописать условие или одно или другое  stringResource(R.string.title_ip)
                    text = stringResource(R.string.title_org),
                    style = MecTheme.typography.h6.semibold,
                    color = MecTheme.colors.text_primary,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 56.dp, bottom = 8.dp)
                )
                //прописать условие или одно или другое
                IPDataBlock()
                CompanyDataBlock()
            }
            item {
                Text(
                    text = stringResource(R.string.title_documents),
                    style = MecTheme.typography.h6.semibold,
                    color = MecTheme.colors.text_primary,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 56.dp, bottom = 8.dp)
                )
                AddDocumentBlock()
            }
            item {
                AddDocumentBlock()
            }
            item {
                AddDocumentBlock()
            }
            item {
                AddDocumentBlock()
            }
        }
    }
}

@Composable
fun RouterBlock() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
            .background(MecTheme.colors.white)
            .border(1.dp, color = MecTheme.colors.bg_tertiary)
    ) {
        Text(
            text = stringResource(R.string.title_router),
            style = MecTheme.typography.h5.semibold,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
            color = MecTheme.colors.text_primary
        )
        Column() {
            Text(
                text = stringResource(R.string.description_list_router),
                style = MecTheme.typography.h6.regular,
                color = MecTheme.colors.text_secondary,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
            )
            Column() {
                Image(painter = painterResource(R.drawable.img_cart_requests), contentDescription = "")
                Text(
                    text = "Alibaba.com",
                    style = MecTheme.typography.body_1.semibold,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
                    color = MecTheme.colors.text_primary
                )
            }
        }
        Text(
            text = stringResource(R.string.description_router),
            style = MecTheme.typography.h6.regular,
            color = MecTheme.colors.text_secondary,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        )
        ButtonOutlined(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            onClick = { },
            text = stringResource(R.string.btn_router),
        )
    }
}

@Composable
fun DigitalSignatureBlock() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
            .background(MecTheme.colors.white)
            .border(1.dp, color = MecTheme.colors.bg_tertiary)
    ) {
        Text(
            text = stringResource(R.string.title_edp),
            style = MecTheme.typography.h5.semibold,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
            color = MecTheme.colors.text_primary
        )
        ButtonOutlined(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            onClick = { },
            text = stringResource(R.string.btn_edp),
        )
    }
}

@Composable
fun PersonalizationDataBlock() {
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
        label = stringResource(R.string.title_last_name),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_first_name),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_middle_name),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_profession),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_phone),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_email),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
}

@Composable
fun IPDataBlock() {
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
        label = stringResource(R.string.title_ogrn_ip),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_inn),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_web_site),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_market),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_value_export),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
}

@Composable
fun CompanyDataBlock() {
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_org_name),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_min_name),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_form_org),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_ogrn),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_inn),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_kpp),
        text = "Логин (телефон, email или СНИЛС)"
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_address_legal),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_address_fact),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_email_organisation),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
        label = stringResource(R.string.title_phone_organisation),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp, top = 16.dp),
        label = stringResource(R.string.title_web_site),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_okved),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_okpo),
        text = "Логин (телефон, email или СНИЛС)",
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_market),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    TextFieldInput(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        label = stringResource(R.string.title_value_export),
        text = "Логин (телефон, email или СНИЛС)",
        isEnabled = true
    )
    ButtonPrimary(onClick = {}, text = "Сохранить", modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp))
}

@Composable
fun AddDocumentBlock() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
            .background(MecTheme.colors.white)
            .border(1.dp, color = MecTheme.colors.bg_tertiary)
    ) {
        Row() {
            Icon(
                modifier = Modifier.padding(start = 16.dp, end = 4.dp, top = 16.dp),
                painter = painterResource(R.drawable.ic_document),
                contentDescription = "",
                tint = Color.Unspecified
            )
            Text(
                text = "Document.pdf",
                style = MecTheme.typography.body_1.semibold,
                modifier = Modifier.padding(end = 16.dp, top = 24.dp, bottom = 8.dp),
                color = MecTheme.colors.accent_primary
            )
        }
        Row() {
            Icon(
                modifier = Modifier.padding(start = 16.dp, end = 4.dp, top = 15.dp),
                painter = painterResource(R.drawable.ic_success_requests),
                contentDescription = "",
                tint = Color.Unspecified
            )
            Text(
                text = "Верифицировано",
                style = MecTheme.typography.body_1.semibold,
                modifier = Modifier.padding(end = 16.dp, top = 16.dp, bottom = 8.dp),
                color = MecTheme.colors.success
            )
        }
        Text(
            text = "Устав",
            style = MecTheme.typography.body_1.semibold,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
            color = MecTheme.colors.text_primary
        )
        Text(
            text = "4.06.2023",
            style = MecTheme.typography.h6.regular,
            color = MecTheme.colors.text_secondary,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        )
        ButtonPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            onClick = { },
            text = stringResource(R.string.btn_delete),
            isEnabled = false
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
            .background(MecTheme.colors.white)
            .border(1.dp, color = MecTheme.colors.bg_tertiary)
    ) {
        Text(
            text = stringResource(R.string.title_document),
            style = MecTheme.typography.body_1.regular,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp),
            color = MecTheme.colors.text_tertiary
        )
        Text(
            text = "Финансовая отчетность",
            style = MecTheme.typography.body_1.semibold,
            color = MecTheme.colors.text_tertiary,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        )
        ButtonPrimary(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            onClick = { },
            text = stringResource(R.string.btn_add_document),
            iconId = R.drawable.ic_plus_btn
        )
    }
}

@Composable
fun StatusExportBlock() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp, start = 16.dp, end = 16.dp, bottom = 20.dp)
            .background(MecTheme.colors.white)
            .border(1.dp, color = MecTheme.colors.bg_tertiary)
    ) {
        Row(modifier = Modifier.padding(10.dp)) {
            Column(modifier = Modifier.weight(0.5f)) {
                Text(
                    text = stringResource(R.string.description_result),
                    style = MecTheme.typography.h6.regular,
                    color = MecTheme.colors.text_secondary,
                    modifier = Modifier.padding(end = 16.dp, bottom = 8.dp)
                )
                ButtonOutlined(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp, end = 16.dp, bottom = 16.dp),
                    onClick = { },
                    text = stringResource(R.string.btn_router),
                )
            }
            CircularProgressIndicatorSample()
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun CircularProgressIndicatorSample() {
    var progress by remember { mutableStateOf(0.8f) }
    val animatedProgress = animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    ).value

    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            progress = animatedProgress,
            color = MecTheme.colors.accent_primary,
            strokeWidth = 18.dp,
            modifier = Modifier
                .size(180.dp)
                .padding(5.dp)
        )
        Text(text = "86%", color = MecTheme.colors.accent_primary, style = MecTheme.typography.h4.semibold)
    }
}

@Composable
@Preview(showBackground = true)
private fun ProfileViewPreview() {
    MecTheme {
        ProfileView()
    }
}
