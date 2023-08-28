package pro.midev.mec.domain.repository

import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.base.mapTo
import pro.midev.mec.data.remote.Api
import pro.midev.mec.data.remote.model.response.TokenResponse
import pro.midev.mec.data.remote.model.response.toDomain
import pro.midev.mec.domain.model.AccountDomain

class AccountRepositoryRemote(
    private val api: Api
) : AccountRepository {
    override suspend fun getAccount(): DataStatus<AccountDomain> {
        return handleRequest { api.getAccount() }.mapTo { it.toDomain() }
    }

    override suspend fun deleteAccount(): CompletableStatus {
        return CompletableStatus.Success // todo
    }

    suspend fun getToken( // получение токена
        code: String
    ): DataStatus<TokenResponse> = handleTokenRequest {
        api.getToken(credentialsOrCode = code)
    }


}