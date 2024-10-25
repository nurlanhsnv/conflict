enum class TicketTypeEnum(val code: String) {
    REGULAR("r"),
    VIP("v"),
    STUDENT("s");

    companion object {
        fun fromCode(code: String): TicketTypeEnum? {
            return entries.find { it.code.equals(code, ignoreCase = true) }
        }
    }
}