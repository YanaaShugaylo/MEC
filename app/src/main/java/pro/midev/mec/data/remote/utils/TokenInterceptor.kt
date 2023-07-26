package pro.midev.mec.data.remote.utils

import okhttp3.Interceptor
import okhttp3.Response
import pro.midev.mec.data.local.keystorage.UserKeyStorage

class TokenInterceptor(private val userKeyStorage: UserKeyStorage) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val request = original.newBuilder()
            .also {
                val token = userKeyStorage.getToken()
                if (!token.isNullOrEmpty()) {
                    it.header("Authorization", "Bearer $token")
                }
            }
            .build()

        return chain.proceed(request)
    }

}