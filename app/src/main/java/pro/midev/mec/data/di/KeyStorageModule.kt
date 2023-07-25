package pro.midev.mec.data.di

import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val keyStorageModule = module {

    single {
        MMKV.initialize(androidContext())
        MMKV.defaultMMKV()
    }

    // todo
}