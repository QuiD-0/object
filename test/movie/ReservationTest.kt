package movie

import movie.domain.*
import movie.usecase.Reservation
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.LocalDateTime

class ReservationTest {

    @Test
    @DisplayName("예매")
    fun reserve() {
        val movie = Movie("반지의 제왕", Duration.ofMinutes(180))
        val screening = Screening(movie, 1, Money(10000), Seats(mutableListOf(),100), LocalDateTime.now())
        val customers = listOf(Customer("홍길동", Money(10000)), Customer("김철수", Money(10000)))

        val reservation = Reservation(screening, Cash(Money(10000)), customers, PercentDiscountPolicy(50))
        val result = reservation.invoke()

        assertEquals(Money(0), result.remainMoney)
    }
}