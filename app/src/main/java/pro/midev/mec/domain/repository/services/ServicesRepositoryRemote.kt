package pro.midev.mec.domain.repository.services

import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.base.mapTo
import pro.midev.mec.data.remote.MecApi
import pro.midev.mec.data.remote.model.response.toDomain
import pro.midev.mec.domain.model.ServiceDomain

class ServicesRepositoryRemote(
    private val mecApi: MecApi
) : ServicesRepository {

    suspend fun getServices(): DataStatus<List<ServiceDomain>> {
        return handleRequest { mecApi.getServices() }.mapTo { it.toDomain() }
    }
}
