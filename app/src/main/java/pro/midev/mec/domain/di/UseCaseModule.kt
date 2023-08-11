package pro.midev.mec.domain.di

import org.koin.dsl.module
import pro.midev.mec.domain.usecase.GetAccountUseCase
import pro.midev.mec.domain.usecase.GetTokenUseCase
import pro.midev.mec.domain.usecase.account.GetFingerInfoUseCase
import pro.midev.mec.domain.usecase.account.GetIsTouchModeUseCase
import pro.midev.mec.domain.usecase.account.PinGetUseCase
import pro.midev.mec.domain.usecase.account.PinSaveUseCase
import pro.midev.mec.domain.usecase.account.SaveIsTouchModeUseCase

val useCaseModule = module {

    factory {
        GetAccountUseCase(get())
    }

    factory {
        GetTokenUseCase(get(), get())
    }

    factory {
        PinSaveUseCase(get())
    }

    factory {
        GetFingerInfoUseCase(get())
    }

    factory {
        PinGetUseCase(get())
    }

    factory {
        SaveIsTouchModeUseCase(get())
    }

    factory {
        GetIsTouchModeUseCase(get())
    }

}
