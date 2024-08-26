package movie.usecase.discountPolicy

import movie.domain.DiscountPolicy
import com.quid.movie.domain.Money

data class AmountDiscountPolicy(
    val discountAmount: Money
) : DiscountPolicy {
    override fun discountAmount(amount: Money): Money {
        return amount - discountAmount
    }
}