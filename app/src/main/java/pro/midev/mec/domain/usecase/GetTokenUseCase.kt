package pro.midev.mec.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.local.keystorage.UserKeyStorage
import pro.midev.mec.domain.base.BaseUseCase
import pro.midev.mec.domain.repository.AccountRepositoryRemote

class GetTokenUseCase(
    private val remoteRepository: AccountRepositoryRemote,
    private val userKeyStorage: UserKeyStorage
) : BaseUseCase {

    operator fun invoke(code : String) : Flow<CompletableStatus> = flow {
        when(val tokenResponse = remoteRepository.getToken(code)){
            is DataStatus.Error -> emit(CompletableStatus.Error(tokenResponse.ex))
            DataStatus.Loading -> {
                emit(CompletableStatus.Loading)
            }

            is DataStatus.Success -> {
                userKeyStorage.saveToken(tokenResponse.data?.token ?: "") // вопросики!!!
                emit(CompletableStatus.Success)
            }
        }
    }

}