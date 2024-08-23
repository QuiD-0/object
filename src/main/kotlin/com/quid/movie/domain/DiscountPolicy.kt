package movie.domain

interface DiscountPolicy {
    fun discountAmount(amount: Money): Money
}

