package movie.domain

import com.quid.movie.domain.Money

interface DiscountPolicy {
    fun discountAmount(amount: Money): Money
}

