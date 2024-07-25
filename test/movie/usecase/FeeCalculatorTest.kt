package movie.usecase

import movie.domain.Money
import movie.domain.PercentDiscountPolicy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FeeCalculatorTest {
    @Test
    fun calculate() {
        val totalAmount = Money(20000)
        val feeCalculator = FeeCalculator(totalAmount, PercentDiscountPolicy(totalAmount, 50))

        val result = feeCalculator.calculate()

        assertEquals(Money(10000), result)
    }
}