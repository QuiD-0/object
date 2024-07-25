package movie.domain

sealed interface DiscountPolicy {
    fun discountAmount(amount: Money) : Money
}

data object NoneDiscountPolicy : DiscountPolicy {
    override fun discountAmount(amount: Money): Money {
        return amount
    }
}

data class PercentDiscountPolicy(
    val percent: Int
) : DiscountPolicy {
    override fun discountAmount(amount: Money): Money {
        return amount - (amount * percent) / 100
    }
}

data class AmountDiscountPolicy(
    val discountAmount: Money
) : DiscountPolicy {
    override fun discountAmount(amount: Money): Money {
        return amount - discountAmount
    }
}