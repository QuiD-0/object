package movie

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.LocalDateTime

class DiscountPolicyTest {

    @Test
    @DisplayName("무할인 정책 적용")
    fun applyDiscount() {
        val movie = Movie("반지의 제왕", Duration.ofMinutes(180))
        val screening = Screening(movie, 1, Money(10000), LocalDateTime.of(2021, 10, 1, 10, 0))
        val customer = Customer("홍길동", Money(20000))

        val reservation = Reservation(screening, Seats(mutableListOf(), 100))
        val response = reservation.invoke(Money(20000), listOf(customer), NoneDiscountPolicy)

        assertEquals(Money(10000), response.remainMoney)
    }

    @Test
    @DisplayName("고정금액 할인 정책 적용")
    fun applyAmountDiscount() {
        val movie = Movie("반지의 제왕", Duration.ofMinutes(180))
        val screening = Screening(movie, 1, Money(10000), LocalDateTime.of(2021, 10, 1, 10, 0))
        val customer = Customer("홍길동", Money(20000))

        val reservation = Reservation(screening, Seats(mutableListOf(), 100))
        val response = reservation.invoke(Money(20000), listOf(customer), AmountDiscountPolicy(Money(5000)))

        assertEquals(Money(5000), response.remainMoney)
    }

    @Test
    @DisplayName("비율 할인 정책 적용")
    fun applyPercentDiscount() {
        val movie = Movie("반지의 제왕", Duration.ofMinutes(180))
        val screening = Screening(movie, 1, Money(10000), LocalDateTime.of(2021, 10, 1, 10, 0))
        val customer = Customer("홍길동", Money(20000))

        val reservation = Reservation(screening, Seats(mutableListOf(), 100))
        val response = reservation.invoke(Money(20000), listOf(customer), PercentDiscountPolicy(Money(10000), 50))

        assertEquals(Money(5000), response.remainMoney)
    }

}