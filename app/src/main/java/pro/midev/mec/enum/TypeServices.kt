package pro.midev.mec.enum

enum class TypeServices(
    val value: String
) {
    FINANCES("financial"), UNFINANCES("not_financial"), RECOMMEND("recommend");

    companion object {
        fun fromValue(value: String) = TypeServices.values().firstOrNull { it.value == value }
    }
}
