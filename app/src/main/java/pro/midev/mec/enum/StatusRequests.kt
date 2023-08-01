package pro.midev.mec.enum

enum class StatusRequests {
    STATUS, ERROR, EDIT, SUCCESS, WARNING;

    companion object {
        fun parse(type: StatusRequests) = when (type) {
            STATUS -> 1
            WARNING -> 2
            SUCCESS -> 3
            ERROR -> 4
            EDIT -> 5
        }
    }
}
