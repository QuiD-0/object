package movie

import com.quid.movie.domain.Money
import movie.domain.*
import movie.usecase.Reservation
import movie.usecase.discountPolicy.AmountDiscountPolicy
import movie.usecase.discountPolicy.NoneDiscountPolicy
import movie.usecase.discountPolicy.PercentDiscountPolicy
import movie.usecase.payMethod.Cash
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.LocalDateTime

class DiscountPolicyTest {

    private val movie = Movie("반지의 제왕", Duration.ofMinutes(180))
    private val screening = Screening(movie, 1, Money(10000), Seats(mutableListOf(), 100), LocalDateTime.now())
    private val customers = listOf(Customer("홍길동", Money(10000)), Customer("김철수", Money(10000)))

    @Test
    @DisplayName("무할인 정책 적용")
    fun applyDiscount() {
        val reservation = Reservation(screening, Cash(Money(20000)), customers, NoneDiscountPolicy)
        val result = reservation.invoke()
        assertEquals(Money(0), result.remainMoney)
    }

    @Test
    @DisplayName("고정금액 할인 정책 적용")
    fun applyAmountDiscount() {
        val reservation = Reservation(screening, Cash(Money(20000)), customers, AmountDiscountPolicy(Money(5000)))
        val result = reservation.invoke()
        assertEquals(Money(5000), result.remainMoney)
    }

    @Test
    @DisplayName("비율 할인 정책 적용")
    fun applyPercentDiscount() {
        val reservation = Reservation(screening, Cash(Money(20000)), customers, PercentDiscountPolicy(50))
        val result = reservation.invoke()
        assertEquals(Money(10000), result.remainMoney)
    }

}