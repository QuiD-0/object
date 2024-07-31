package movie.usecase.discountPolicy

import movie.domain.DiscountPolicy
import movie.domain.Money

data class AmountDiscountPolicy(
    val discountAmount: Money
) : DiscountPolicy {
    override fun discountAmount(amount: Money): Money {
        return amount - discountAmount
    }
}