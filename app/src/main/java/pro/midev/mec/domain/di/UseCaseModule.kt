package pro.midev.mec.domain.di

import org.koin.dsl.module
import pro.midev.mec.domain.usecase.GetAccountUseCase
import pro.midev.mec.domain.usecase.GetTokenUseCase
import pro.midev.mec.domain.usecase.account.PinSaveUseCase

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
}
