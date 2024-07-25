package movie.usecase.discountPolicy

import movie.domain.DiscountPolicy
import movie.domain.Money

data object NoneDiscountPolicy : DiscountPolicy {
    override fun discountAmount(amount: Money): Money {
        return amount
    }
}