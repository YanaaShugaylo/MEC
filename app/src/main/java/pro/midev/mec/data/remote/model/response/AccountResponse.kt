package pro.midev.mec.data.remote.model.response

import pro.midev.mec.domain.model.AccountDomain

data class AccountResponse(
    val lastName: String?,
    val firstName: String?,
    val middleName: String?,
    val email: String?,
    val phone: String? = null,
    val id: String?
)

fun AccountResponse.toDomain() = AccountDomain(
    lastName = lastName,
    firstName = firstName,
    email = email,
    phone = phone,
    middleName = middleName,
    id = id
)
