package movie.usecase.discountPolicy

import movie.domain.DiscountPolicy
import com.quid.movie.domain.Money

data class PercentDiscountPolicy(
    val percent: Int
) : DiscountPolicy {
    override fun discountAmount(amount: Money): Money {
        return amount - (amount * percent) / 100
    }
}