package pro.midev.mec

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import pro.midev.mec.data.di.localDbModule
import pro.midev.mec.data.di.keyStorageModule
import pro.midev.mec.data.di.remoteStorageModule
import pro.midev.mec.domain.di.repositoryModule
import pro.midev.mec.domain.di.useCaseModule
import pro.midev.mec.presentation.di.viewModelModule
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@App.baseContext)
            modules(
                viewModelModule,
                keyStorageModule,
                localDbModule,
                remoteStorageModule,
                repositoryModule,
                useCaseModule
            )
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

}
