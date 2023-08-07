package pro.midev.mec.domain.repository

import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.domain.base.BaseRepository
import pro.midev.mec.domain.model.AccountDomain

interface AccountRepository : BaseRepository {
    suspend fun getAccount(): DataStatus<AccountDomain>

    suspend fun deleteAccount(): CompletableStatus


}