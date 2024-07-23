package movie

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
) {
    init {
        require(amount >= BigDecimal.ZERO) { "amount must be greater than or equal to 0" }
    }

    override fun toString(): String = "$amount 원"

    fun isEnough(money: Money): Boolean = this.amount >= money.amount

    operator fun plus(money: Money): Money = copy(amount = this.amount + money.amount)

    operator fun minus(money: Money): Money = copy(amount = this.amount - money.amount)
}