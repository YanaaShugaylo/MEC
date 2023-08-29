package pro.midev.mec.presentation.model

import androidx.compose.runtime.Immutable

@Immutable
class ServiceHuman(
    val id: Long,
    val isMec: Long,
    val type: String,
    val preFeed: Boolean,
    val invisible: Boolean,
    val isrppId: String,
    val prefeedId: Long,
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
            type = "",
            preFeed = false,
            invisible = false,
            isrppId = "",
            prefeedId = 0L,
            previewTitle = "",
            smallImage = "",
            image = "",
            previewImage = "",
            title = ""

        )
    }
}