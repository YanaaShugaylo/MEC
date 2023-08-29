package pro.midev.mec.data.remote

import pro.midev.mec.data.remote.model.response.DataWrapper
import pro.midev.mec.data.remote.model.response.ServiceResponse
import retrofit2.http.GET

interface MecApi {
    @GET("services")
    suspend fun getServices(): DataWrapper<List<ServiceResponse>>

}