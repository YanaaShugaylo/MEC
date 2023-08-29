package pro.midev.mec.data.remote.model.response

import pro.midev.mec.domain.model.ServiceDomain

data class ServiceResponse(
    val id: Long?,
    val isMec: Long?,
    val type: String?,
    val preFeed: Boolean?,
    val invisible: Boolean?,
    val isrppId: String?,
    val prefeedId: Long?,
    val previewTitle: String?,
    val smallImage: String?,
    val image: String?,
    val previewImage: String?,
    val title: String?
)

fun ServiceResponse.toDomain() = ServiceDomain(
    id = id,
    isMec = isMec,
    type = type,
    preFeed = preFeed,
    invisible = invisible,
    isrppId = isrppId,
    prefeedId = prefeedId,
    previewTitle = previewTitle,
    smallImage = smallImage,
    image = image,
    previewImage = previewImage,
    title = title
)

fun List<ServiceResponse>.toDomain() = map { it.toDomain() }
