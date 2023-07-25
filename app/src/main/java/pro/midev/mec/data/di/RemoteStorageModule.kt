package pro.midev.mec.data.di

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
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
                if (BuildConfig.DBUG) {
                    it.addInterceptor(
                        HttpLoggingInterceptor(ApiLogger())
                            .setLevel(HttpLoggingInterceptor.Level.BODY))
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

    single {
        get<Retrofit.Builder>()
            .baseUrl(BuildConfig.SERVER_URL)
            .build()
    }

    single {
        get<Retrofit>().create(Api::class.java)
    }

}
