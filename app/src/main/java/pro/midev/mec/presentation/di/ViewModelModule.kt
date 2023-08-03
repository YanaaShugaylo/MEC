package pro.midev.mec.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pro.midev.mec.presentation.ui.screens.auth.AuthViewModel
import pro.midev.mec.presentation.ui.screens.splash.SplashViewModel

val viewModelModule = module {

    viewModel {
        AuthViewModel()
    }

    viewModel {
        SplashViewModel()
    }
}
