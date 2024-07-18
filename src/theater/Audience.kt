package theater

data class Audience(
    val bag: Bag
) {
    fun pay(amount: Long) :Long = bag.pay(amount)
    fun hasInvitation(): Boolean = bag.hasInvitation()
}