@file:Suppress("UNREACHABLE_CODE")

package pro.midev.mec.presentation.ui.screens.auth

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import pro.midev.mec.presentation.ui.style.MecTheme


@Composable
fun AuthView(
    state: AuthState,
    eventConsumer: (AuthEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(MecTheme.colors.white)
            .statusBarsPadding()
    ) {
        AndroidView(factory = {
            WebView(it).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                settings.javaScriptEnabled = true
                webViewClient = object : WebViewClient() {

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        if (url?.contains("login?code=") == true) {
                            val x = 5
                        }
                    }
                }
                loadUrl(state.link)


            }
        }, update = {
            it.loadUrl(state.link)
        })
    }
}

@Composable
@Preview
private fun AuthPreview() {
    MecTheme() {
        AuthView(
            state = AuthState(link = "https://login.mos.ru/sps/oauth/ae?client_id=lk.moscow-export&scope=openid+profile+birthday+usr_grps&redirect_uri=http://mobile.moscow-export.com/login&response_type=code"),
            eventConsumer = {}
        )
    }
}
