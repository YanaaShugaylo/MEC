package pro.midev.mec.data.remote

import pro.midev.mec.data.remote.model.response.AccountResponse
import pro.midev.mec.data.remote.model.response.DataWrapper
import pro.midev.mec.data.remote.model.response.TokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ServerApi {

    @GET("account")
    suspend fun getAccount(): DataWrapper<AccountResponse>

    @FormUrlEncoded
    @POST("auth")
    suspend fun getToken(
        @Field("provider") provider : String = "SUDIR",
        @Field("credentialsOrCode") credentialsOrCode : String
    ) : TokenResponse // todo продумать сетевой слой

}