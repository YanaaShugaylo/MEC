package pro.midev.mec.domain.usecase.services

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.base.mapTo
import pro.midev.mec.domain.model.toHuman
import pro.midev.mec.domain.repository.services.ServicesRepositoryRemote
import pro.midev.mec.presentation.model.ServiceHuman

class GetServicesUseCase(
    private val remoteRepository: ServicesRepositoryRemote
) {
    suspend operator fun invoke(): Flow<DataStatus<List<ServiceHuman>>> = flow {
        emit(DataStatus.Loading)
        when (val account = remoteRepository.getServices()) {
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