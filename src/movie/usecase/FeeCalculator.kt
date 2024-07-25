package movie.usecase

import movie.domain.DiscountPolicy
import movie.domain.Money

data class FeeCalculator(
    val amount: Money,
    val discountPolicy: DiscountPolicy,
) {
    fun calculate(): Money = amount - discountPolicy.discountAmount()
}
