package pro.midev.mec.domain.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Dispatcher
import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.local.keystorage.UserKeyStorage
import pro.midev.mec.domain.model.AccountDomain
import pro.midev.mec.ext.withIO

class AccountRepositoryLocal(
    private val keyStorage: UserKeyStorage
) : AccountRepository {
    override suspend fun getAccount(): DataStatus<AccountDomain> {
        TODO("Not yet implemented") // сделаем сохранение в БД
    }

    override suspend fun deleteAccount(): CompletableStatus {
        TODO("Not yet implemented") // сделаем удаление из БД
    }

    suspend fun savePin(pin: String): CompletableStatus = withContext(Dispatchers.IO) {
        try {
            keyStorage.savePin(pin)
            CompletableStatus.Success
        } catch (ex: Exception) {
            CompletableStatus.Error(ex)
        }
    }

    suspend fun getPin(): DataStatus<String> = withContext(Dispatchers.IO) {
        val pin = keyStorage.getPin()
        if (pin == null) {
            DataStatus.Error(NullPointerException())
        } else {
            DataStatus.Success(pin)
        }
    }

    suspend fun getIsTouchMode(): DataStatus<Boolean> = withContext(Dispatchers.IO) {
        val isTouchMode = keyStorage.getIsTouchMode()
        if (isTouchMode == null) {
            DataStatus.Error(NullPointerException())
        } else {
            DataStatus.Success(isTouchMode)
        }
    }

    suspend fun saveTouchMode(isTouchMode: Boolean): CompletableStatus = withContext(Dispatchers.IO) {
        try {
            keyStorage.saveIsTouchMode(isTouchMode)
            CompletableStatus.Success
        } catch (ex: Exception) {
            CompletableStatus.Error(ex)
        }
    }

    suspend fun removePin(): CompletableStatus = withIO {
        return@withIO try {
            keyStorage.removePin()
            CompletableStatus.Success
        } catch (ex: Exception) {
            CompletableStatus.Error(ex)
        }
    }


}