package theater

data class Ticket(
    val name: String,
    val price: Long
) {
    fun isEnoughPrice(fee: Long): Boolean = price <= fee
}