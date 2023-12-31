package pro.midev.mec.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pro.midev.mec.presentation.ui.screens.auth.AuthViewModel
import pro.midev.mec.presentation.ui.screens.auth.finger_print.FingerPrintViewModel
import pro.midev.mec.presentation.ui.screens.main_profile.MainProfileViewModel
import pro.midev.mec.presentation.ui.screens.pin.enter.EnterPinViewModel
import pro.midev.mec.presentation.ui.screens.services.MainServicesViewModel
import pro.midev.mec.presentation.ui.screens.services.service_detail.ServiceDetailViewModel
import pro.midev.mec.presentation.ui.screens.splash.SplashViewModel

val viewModelModule = module {

    viewModel {
        AuthViewModel(get())
    }

    viewModel {
        SplashViewModel(get(), get())
    }

    viewModel { parameters ->
        EnterPinViewModel(get(), get(), get(), get(), parameters[0])
    }

    viewModel {
        FingerPrintViewModel(get())
    }

    viewModel { MainProfileViewModel() }

    viewModel {
        MainServicesViewModel(get())
    }

    viewModel {
        ServiceDetailViewModel(get())
    }

}

