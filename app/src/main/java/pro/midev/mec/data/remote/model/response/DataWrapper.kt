package pro.midev.mec.data.remote.model.response

import com.google.gson.annotations.SerializedName
import pro.midev.mec.data.base.CompletableStatus
import pro.midev.mec.data.base.DataStatus
import pro.midev.mec.data.remote.exceptions.MecRemoteException
import java.io.IOException

data class DataWrapper<T>(
    val success: Boolean?,
    val message: String?,
    @SerializedName(value = "data", alternate = arrayOf("account"))
    val data: T?
)

fun <K : Any> DataWrapper<K>.toDataStatus(): DataStatus<K> {
    return if (this.success == true && this.data != null) {
        DataStatus.Success(this.data)
    } else {
        DataStatus.Error(
            when {
                this.success != true -> {
                    if (this.message.isNullOrEmpty())
                        IllegalStateException(this.message)
                    else
                        MecRemoteException(this.message)
                }

                this.data == null -> NullPointerException(this.message)
                else -> IOException(this.message)
            }
        )
    }
}

fun TokenResponse.toDataStatus(): DataStatus<TokenResponse> {
    return if (this.success == true && this.token != null) {
        DataStatus.Success(this.token)
    } else {
        DataStatus.Error(
            when {
                this.success != true -> {
                    if (this.message.isNullOrEmpty())
                        IllegalStateException(this.message)
                    else
                        MecRemoteException(this.message)
                }

                this.token == null -> NullPointerException(this.message)
                else -> IOException(this.message)
            }
        )
    }
}

data class CompletableData(
    val success: Boolean?,
    val message: String?
)

fun CompletableData.toCompletableStatus(): CompletableStatus {
    return if (this.success == true) {
        CompletableStatus.Success
    } else {
        CompletableStatus.Error(
            when {
                this.success != true -> {
                    IllegalStateException(this.message)
                }

                else -> IOException(this.message)
            }
        )
    }
}
