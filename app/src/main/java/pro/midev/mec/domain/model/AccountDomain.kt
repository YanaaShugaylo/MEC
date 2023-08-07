package pro.midev.mec.domain.model

import pro.midev.mec.presentation.model.AccountHuman

data class AccountDomain(
    val id: String = ""
)

fun AccountDomain.toHuman() = AccountHuman(id = id)