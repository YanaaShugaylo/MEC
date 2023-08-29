package pro.midev.mec.domain.repository.account

import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.base.mapTo
import pro.midev.mec.data.remote.ServerApi
import pro.midev.mec.data.remote.model.response.TokenResponse
import pro.midev.mec.data.remote.model.response.toDomain
import pro.midev.mec.domain.model.AccountDomain
import pro.midev.mec.domain.repository.account.AccountRepository

class AccountRepositoryRemote(
    private val serverApi: ServerApi
) : AccountRepository {
    override suspend fun getAccount(): DataStatus<AccountDomain> {
        return handleRequest { serverApi.getAccount() }.mapTo { it.toDomain() }
    }

    override suspend fun deleteAccount(): CompletableStatus {
        return CompletableStatus.Success // todo
    }

    suspend fun getToken( // получение токена
        code: String
    ): DataStatus<TokenResponse> = handleTokenRequest {
        serverApi.getToken(credentialsOrCode = code)
    }


}