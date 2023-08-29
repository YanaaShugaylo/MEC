package pro.midev.mec.domain.usecase.account

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.domain.base.BaseUseCase
import pro.midev.mec.domain.repository.account.AccountRepositoryLocal

class PinGetUseCase(
    private val localRepository: AccountRepositoryLocal
) : BaseUseCase {

    suspend operator fun invoke(): Flow<DataStatus<String>> = flow {
        emit(localRepository.getPin())
    }

}