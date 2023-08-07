package pro.midev.mec.domain.di

import org.koin.dsl.module
import pro.midev.mec.domain.repository.AccountRepositoryRemote

val repositoryModule = module {

    single {
        AccountRepositoryRemote(get())
    }

}
