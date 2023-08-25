package pro.midev.mec.domain.model

import pro.midev.mec.presentation.model.human.AccountHuman

data class AccountDomain(
    //поля буду использоваться для дальнейшего функционала
/*    val pushChat: Boolean? = null,
    val pushLeads: Boolean? = null,
    val pushOther: Boolean? = null,
    //какой то неведомый id
    val _id: String? = null,

    //нужна моделька
    val company: String? = null,*/
/*    val lastLoginAt: String? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val v: Int? = null,
    val crm: String? = null,
    val positionName: String? = null,*/
    val lastName: String?,
    val firstName: String?,
    val middleName: String?,
    val email: String?,
    val phone: String? = null,
    val orgInn: String? = null,
    val id: String?
)

fun AccountDomain.toHuman() = AccountHuman(
    lastName = lastName,
    firstName = firstName,
    email = email,
    phone = phone,
    middleName = middleName,
    id = id
)
