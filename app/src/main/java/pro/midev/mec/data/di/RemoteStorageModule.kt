package pro.midev.mec.data.di

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import pro.midev.mec.BuildConfig
import pro.midev.mec.data.remote.ServerApi
import pro.midev.mec.data.remote.utils.ApiLogger
import pro.midev.mec.data.remote.utils.HeadersInterceptor
import pro.midev.mec.data.remote.MecApi
import pro.midev.mec.data.remote.utils.NetworkConnectionInterceptor
import pro.midev.mec.data.remote.utils.TokenInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteStorageModule = module {

    single {
        OkHttpClient.Builder()
            .connectTimeout(40, TimeUnit.SECONDS)
            .readTimeout(40, TimeUnit.SECONDS)
            .addInterceptor(HeadersInterceptor())
            .addInterceptor(NetworkConnectionInterceptor(androidContext()))
            .addInterceptor(TokenInterceptor(get()))
            .also {
                if (BuildConfig.DEBUG) {
                    it.addInterceptor(
                        HttpLoggingInterceptor(ApiLogger())
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
                    )
                }
            }
            .build()
    }

    single {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(get())
    }

    single(named("server")) {
        get<Retrofit.Builder>()
            .baseUrl(BuildConfig.SERVER_URL)
            .build()
    }

    single() {
        get<Retrofit>(named("server")).create(ServerApi::class.java)
    }

    single(named("mec")) {
        get<Retrofit.Builder>()
            .baseUrl(BuildConfig.MEC_URL)
            .build()
    }

    single {
        get<Retrofit>(named("mec")).create(MecApi::class.java)
    }

}

