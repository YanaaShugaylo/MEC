package pro.midev.mec.presentation.model

import androidx.compose.runtime.Immutable
import pro.midev.mec.enum.TypeServices

@Immutable
class ServiceHuman(
    val id: Long,
    val isMec: Long,
    val type: TypeServices,
    val preFeed: Boolean,
    val invisible: Boolean,
    val isrppId: String,
    val prefeedId: String,
    val previewTitle: String,
    val smallImage: String,
    val image: String,
    val previewImage: String,
    val title: String
) {
    companion object {
        fun getDefault() = ServiceHuman(
            id = 0L,
            isMec = 0L,
            type = TypeServices.FINANCES,
            preFeed = false,
            invisible = false,
            isrppId = "",
            prefeedId = "",
            previewTitle = "",
            smallImage = "",
            image = "",
            previewImage = "",
            title = ""

        )
    }
}