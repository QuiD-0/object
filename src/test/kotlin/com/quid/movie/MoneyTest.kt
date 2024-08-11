package movie

import movie.domain.Money
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class MoneyTest {

    @Test
    @DisplayName("금액을 더한다")
    fun plus() {
        val money = Money(BigDecimal(1000))
        val result = money + Money(BigDecimal(2000))

        assertEquals(Money(BigDecimal(3000)), result)
    }

    @Test
    @DisplayName("금액을 뺀다")
    fun minus() {
        val money = Money(BigDecimal(2000))
        val result = money - Money(BigDecimal(1000))

        assertEquals(Money(BigDecimal(1000)), result)
    }

    @Test
    @DisplayName("금액이 충분한지 확인한다")
    fun isEnough() {
        val money = Money(BigDecimal(1000))

        assertTrue(money.isEnough(Money(BigDecimal(500))))
    }

    @Test
    @DisplayName("금액이 부족한지 확인한다")
    fun isNotEnough() {
        val money = Money(BigDecimal(1000))

        assertFalse(money.isEnough(Money(BigDecimal(1500))))
    }

    @Test
    @DisplayName("금액이 0보다 작은 경우 예외가 발생한다")
    fun throwExceptionWhenAmountIsNegative() {
        assertThrows(IllegalArgumentException::class.java) {
            Money(BigDecimal(-1000))
        }
    }

}