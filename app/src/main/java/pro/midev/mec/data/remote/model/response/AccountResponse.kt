package pro.midev.mec.data.remote.model.response

import com.google.gson.annotations.SerializedName
import pro.midev.mec.domain.model.AccountDomain

data class AccountResponse(
    @SerializedName("_id")
    val id: String
)

fun AccountResponse.toDomain() = AccountDomain(id = id)