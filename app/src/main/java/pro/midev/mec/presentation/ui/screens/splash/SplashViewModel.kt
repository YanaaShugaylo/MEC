package pro.midev.mec.presentation.ui.screens.splash

import pro.midev.mec.presentation.base.BaseViewModel

class SplashViewModel : BaseViewModel<SplashState, SplashEvent, SplashAction>(
    SplashState()
) {
    override fun obtainEvent(event: SplashEvent) {
        when (event) {
            SplashEvent.OnCreate -> onCreate()
        }
    }

    private fun onCreate() {

    }
}