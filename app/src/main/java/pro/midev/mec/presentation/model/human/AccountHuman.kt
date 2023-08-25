package pro.midev.mec.presentation.model.human

data class AccountHuman(
    //поля будут использоваться для дальнейшего функционала
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
) {
    companion object {

        fun getDefault() = AccountHuman(
            lastName = "Мэцов",
            firstName = "Иосив",
            middleName = "Семенович",
            email = "",
            phone = "",
            orgInn = "1234456",
            id = ""
        )
    }
}
