package movie.domain

import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
) {
    constructor(amount: Int) : this(BigDecimal(amount))

    init {
        require(amount >= BigDecimal.ZERO) { "잔액이 부족합니다." }
    }

    override fun toString(): String = "$amount 원"

    fun isEnough(money: Money): Boolean = this.amount >= money.amount

    operator fun plus(money: Money): Money = copy(amount = this.amount + money.amount)

    operator fun minus(money: Money): Money = copy(amount = this.amount - money.amount)

    operator fun times(audienceCount: Int): Money = copy(amount = this.amount * BigDecimal(audienceCount))

    operator fun div(i: Int): Money = copy(amount = this.amount / BigDecimal(i))
}