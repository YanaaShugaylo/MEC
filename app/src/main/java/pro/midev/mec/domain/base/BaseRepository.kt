package pro.midev.mec.domain.base

import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.remote.model.response.CompletableData
import pro.midev.mec.data.remote.model.response.DataWrapper
import pro.midev.mec.data.remote.model.response.toCompletableStatus
import pro.midev.mec.data.remote.model.response.toDataStatus
import pro.midev.mec.ext.withIO
import retrofit2.HttpException
import timber.log.Timber

interface BaseRepository {
    suspend fun <T : Any> handleRequest(requestFunc: suspend () -> DataWrapper<T>): DataStatus<T> {
        return try {
            withIO { requestFunc() }.toDataStatus()
        } catch (ex: Exception) {
            Timber.e(ex)
            DataStatus.Error(ex)
        }
    }

    suspend fun handleCompletableRequest(requestFunc: suspend () -> CompletableData): CompletableStatus {
        return try {
            withIO { requestFunc() }.toCompletableStatus()
        } catch (ex: HttpException) {
            Timber.e(ex)
            CompletableStatus.Error(ex)
        }
    }
}