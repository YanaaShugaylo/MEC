package pro.midev.mec.presentation.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.midev.mec.R
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
fun TextFieldInput(
    label: String? = null,
    text: String = "",
    placeholder: String = "",
    @DrawableRes iconEnd: Int? = null,
    onEndIconClick: () -> Unit = {},
    errorText: String? = null,
    onValueChange: (value: String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = false,
    isError: Boolean = false,
    minHeight: Int = 55,
    heightUp: Int? = null,
) {
    val hasFocus = remember { mutableStateOf(false) }

    Column() {

        Row(
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth()
                .background(
                    color = MecTheme.colors.white
                )
                .border(
                    width = 1.dp, color = when {
                        isError -> MecTheme.colors.accent_primary
                        hasFocus.value -> MecTheme.colors.info
                        else -> MecTheme.colors.white
                    }
                )
                .padding(horizontal = 16.dp)
        ) {
            Column(
                Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f)
            ) {

                label?.let {
                    Text(
                        text = it,
                        style = MecTheme.typography.overline.regular,
                        color = when {
                            isError -> MecTheme.colors.accent_primary
                            hasFocus.value -> MecTheme.colors.info
                            else -> MecTheme.colors.text_tertiary
                        }
                    )
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    MecBaseInput(
                        modifier = if (heightUp == null) Modifier

                            .onFocusChanged {
                                hasFocus.value = it.hasFocus
                            } else Modifier
                            .height(heightUp.dp)
                            .onFocusChanged {
                                hasFocus.value = it.hasFocus
                            },
                        text = text,
                        onValueChange = onValueChange,
                        textStyle = MecTheme.typography.subtitle_2.regular,
                        cursorBrush = SolidColor(MecTheme.colors.black),
                        placeHolder = placeholder,
                        visualTransformation = visualTransformation,
                        singleLine = singleLine,
                        keyboardOptions = keyboardOptions
                    )
                }
            }

            iconEnd?.let { res ->

                Row(Modifier.align(Alignment.CenterVertically)) {

                    IconButton(modifier = Modifier.size(24.dp), onClick = { onEndIconClick() }) {
                        Icon(
                            painter = painterResource(res),
                            contentDescription = "",
                            tint = MecTheme.colors.accent_primary
                        )
                    }
                }


            }
        }


        AnimatedVisibility(visible = errorText != null) {
            Box(
                modifier = Modifier
                    .padding(start = 12.dp, top = 1.dp)
                    .background(color = MecTheme.colors.white)
                    .padding(horizontal = 4.dp)
            ) {
                Text(
                    text = errorText.orEmpty(),
                    style = MecTheme.typography.overline.regular,
                    color = MecTheme.colors.accent_primary
                )
            }
        }
    }
}

@Composable
fun MecBaseInput(
    modifier: Modifier,
    text: String = "",
    textStyle: TextStyle = MecTheme.typography.body_1.regular,
    placeHolder: String,
    onValueChange: (value: String) -> Unit = {},
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    cursorBrush: Brush = SolidColor(MecTheme.colors.accent_primary),
    singleLine: Boolean = false,
    minLines: Int = 1,
    maxLines: Int = 10
) {
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        modifier = modifier,
        textStyle = textStyle,
        cursorBrush = cursorBrush,
        decorationBox = { innerTextField ->
            TextFieldDecorationBox(value = text, innerTextField = innerTextField, placeholder = {
                Text(
                    text = placeHolder, color = MecTheme.colors.text_tertiary, style = textStyle
                )
            })
        },
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        singleLine = singleLine,
        minLines = minLines,
        maxLines = maxLines
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TextFieldDecorationBox(
    value: String,
    innerTextField: @Composable () -> Unit,
    placeholder: @Composable () -> Unit,
) {
    TextFieldDefaults.TextFieldDecorationBox(
        value = value,
        innerTextField = innerTextField,
        enabled = true,
        singleLine = false,
        visualTransformation = VisualTransformation.None,
        placeholder = placeholder,
        interactionSource = remember { MutableInteractionSource() },
        contentPadding = PaddingValues(all = 0.dp)
    )
}

@Composable
@Preview(showBackground = true)
private fun TextInputFieldPreview() {
    MecTheme {
        Column(Modifier.padding(all = 24.dp), verticalArrangement = Arrangement.spacedBy(24.dp)) {
            TextFieldInput(
                placeholder = "Логин (телефон, email или СНИЛС)"
            )

            TextFieldInput(
                label = "Текст",
                text = "Логин (телефон, email или СНИЛС)"
            )

            TextFieldInput(
                label = "Текст",
                text = "Логин (телефон, email или СНИЛС)",
                isError = true,
                iconEnd = R.drawable.info_input_icon,
                errorText = "Ошибка"
            )

        }
    }
}
