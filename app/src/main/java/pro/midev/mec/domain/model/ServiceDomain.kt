package pro.midev.mec.domain.model

import pro.midev.mec.enum.TypeServices
import pro.midev.mec.presentation.model.ServiceHuman

data class ServiceDomain(
    val id: Long?,
    val isMec: Long?,
    val type: String,
    val preFeed: Boolean?,
    val invisible: Boolean?,
    val isrppId: String?,
    val prefeedId: String?,
    val previewTitle: String?,
    val smallImage: String?,
    val image: String?,
    val previewImage: String?,
    val title: String?
)

fun ServiceDomain.toHuman() = ServiceHuman(
    id = id ?: 0L,
    isMec = isMec ?: 0L,
    type = TypeServices.fromValue(type) ?: TypeServices.FINANCES,
    preFeed = preFeed ?: false,
    invisible = invisible ?: false,
    isrppId = isrppId.orEmpty(),
    prefeedId = prefeedId ?: "",
    previewTitle = previewTitle.orEmpty(),
    smallImage = smallImage.orEmpty(),
    image = image.orEmpty(),
    previewImage = previewImage.orEmpty(),
    title = title.orEmpty()
)

fun List<ServiceDomain>.toHuman() = map { it.toHuman() }
