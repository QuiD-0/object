package theater

import java.util.concurrent.atomic.AtomicLong

data class Bag(
    var amount: AtomicLong,
    val invitation: Invitation? = null,
) {
    init {
        require(amount.get() >= 0) { "amount must be greater than or equal to 0" }
    }

    fun hasInvitation(): Boolean = invitation != null

    fun pay(amount: Long): Long {
        require(this.amount.get() >= amount) { "amount must be greater than or equal to 0" }
        this.amount.addAndGet(-amount)
        return amount
    }
}