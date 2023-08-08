package pro.midev.mec.domain.usecase.account

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.domain.repository.AccountRepositoryLocal

class PinSaveUseCase (
    private val localRepository: AccountRepositoryLocal
) {

    suspend operator fun invoke(pin: String): Flow<CompletableStatus> = flow {
        emit(localRepository.savePin(pin))
    }

}