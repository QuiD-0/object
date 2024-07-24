package movie.domain

import java.math.BigDecimal

sealed interface DiscountPolicy {
    fun discountAmount() : Money
}

data object NoneDiscountPolicy : DiscountPolicy {
    override fun discountAmount(): Money {
        return Money(BigDecimal.ZERO)
    }
}

data class PercentDiscountPolicy(
    val amount : Money,
    val percent: Int
) : DiscountPolicy {
    override fun discountAmount(): Money {
        return (amount * percent) / 100
    }
}

data class AmountDiscountPolicy(
    val discountAmount: Money
) : DiscountPolicy {
    override fun discountAmount(): Money {
        return discountAmount
    }
}