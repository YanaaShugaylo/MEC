package pro.midev.mec.domain.usecase.account

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.domain.repository.account.AccountRepositoryLocal

class SaveIsTouchModeUseCase(
    private val localRepository: AccountRepositoryLocal
) {

    suspend operator fun invoke(isEnabledTouchMode: Boolean): Flow<CompletableStatus> = flow {
        emit(localRepository.saveTouchMode(isEnabledTouchMode))
    }

}