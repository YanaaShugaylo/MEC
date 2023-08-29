package pro.midev.mec.domain.di

import org.koin.dsl.module
import pro.midev.mec.domain.repository.account.AccountRepositoryLocal
import pro.midev.mec.domain.repository.account.AccountRepositoryRemote
import pro.midev.mec.domain.repository.services.ServicesRepositoryRemote

val repositoryModule = module {

    single {
        AccountRepositoryRemote(
            serverApi = get()
        )
    }

    single {
        AccountRepositoryLocal(get())
    }

    single {
        ServicesRepositoryRemote(
            mecApi = get()
        )
    }

}
