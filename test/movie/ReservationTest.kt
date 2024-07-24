package movie

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
        val screening = Screening(movie, 1, Money(10000), LocalDateTime.of(2021, 10, 1, 10, 0))
        val customer = Customer("홍길동", Money(20000))

        val reservation = Reservation(screening, Seats(mutableListOf(), 100))
        val response = reservation.invoke(Money(20000), listOf(customer), NoneDiscountPolicy)

        assertEquals(1, response.tickets.size)
    }
}