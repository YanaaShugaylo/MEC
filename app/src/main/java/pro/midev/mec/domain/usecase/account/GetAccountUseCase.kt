package pro.midev.mec.domain.usecase.account

import pro.midev.mec.data.base.DataSource
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.domain.base.BaseUseCase
import pro.midev.mec.domain.repository.account.AccountRepositoryRemote
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.midev.mec.data.base.mapTo
import pro.midev.mec.domain.model.toHuman
import pro.midev.mec.presentation.model.AccountHuman

class GetAccountUseCase(
    private val remoteRepository: AccountRepositoryRemote
) : BaseUseCase {
    suspend operator fun invoke(source: DataSource = DataSource.REMOTE): Flow<DataStatus<AccountHuman>> {
        return when (source) {
            DataSource.REMOTE -> getAccountRemote()
            DataSource.LOCAL -> getAccountRemote() // todo
        }
    }

    private suspend fun getAccountRemote(): Flow<DataStatus<AccountHuman>> = flow {
        when (val account = remoteRepository.getAccount()) {
            is DataStatus.Success -> {
                emit(account.mapTo { it.toHuman() })
            }

            is DataStatus.Error -> {
                emit(DataStatus.Error(account.ex))
            }

            else -> {}
        }
    }
}