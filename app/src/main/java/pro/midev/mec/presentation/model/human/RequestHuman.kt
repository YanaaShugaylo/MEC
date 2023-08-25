package pro.midev.mec.presentation.model.human

data class RequestHuman(
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
    val num: String? = null,
    //создать модельку
    val status: String? = null,

    val id: String?,
    val name: String?,
    val comment: String? = null,
    val files: MutableList<String>? = null,
    val createdAt: String? = null,
    val updatedAt: String? = null
)
