package pro.midev.mec.domain.model

import pro.midev.mec.presentation.model.human.AccountHuman
import pro.midev.mec.presentation.model.human.RequestHuman

data class RequestDomain(
    //поля для дальнейшего функционала
    /*    val isrppId: String? = null,
    val crmId: String? = null,
    val synced: Boolean? = null,*/
    /*    //создать модельку
    val measureService: MutableList<String>,
    val feedback: Boolean? = null,
    //создать модельку
    val feedbackData: String,
    val printFormUrl: String,*/
    //создать модельку
    val num: String?,
    //создать модельку
    val status: String?,

    val id: String?,
    val name: String?,
    val comment: String? = null,
    val files: MutableList<String>? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)

fun RequestDomain.toHuman() = RequestHuman(
    id = id,
    name = name,
    num = num,
    status = status
)
