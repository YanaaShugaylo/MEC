package pro.midev.mec.enum

enum class TypeServices(
    val value : String
) {
    FINANCES("finances"), UNFINANCES("unfinances"), RECOMMEND("recommend");

    companion object {
        fun fromValue(value: String) = TypeServices.values().firstOrNull { it.value == value }
    }
}