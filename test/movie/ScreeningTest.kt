package movie

import movie.domain.Money
import movie.domain.Movie
import movie.domain.Screening
import movie.domain.Seats
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.Duration
import java.time.LocalDateTime

class ScreeningTest {

    private val movie = Movie("타이타닉", Duration.ofMinutes(120))
    private val screening = Screening(movie, 1, Money(BigDecimal(10000)), Seats(mutableListOf(), 200), LocalDateTime.of(2021, 1, 1, 10, 0))

    @Test
    @DisplayName("영화 시작 시간을 반환한다")
    fun startTime() {
        assertEquals(LocalDateTime.of(2021, 1, 1, 10, 0), screening.getStartTime())
    }

    @Test
    @DisplayName("영화 종료 시간을 반환한다")
    fun endTime() {
        assertEquals(LocalDateTime.of(2021, 1, 1, 12, 0), screening.getEndTime())
    }

    @Test
    @DisplayName("상영 순번이 일치하는지 확인한다")
    fun isSameSeq() {
        assertTrue(screening.isSequence(1))
    }

    @Test
    @DisplayName("상영 순번이 일치하지 않는지 확인한다")
    fun isNotSameSeq() {
        assertTrue(screening.isAfterScreening(LocalDateTime.of(2021, 1, 1, 9, 0)))
    }

    @Test
    @DisplayName("상영 시간이 지나지 않았는지 확인한다")
    fun isNotAfterScreening() {
        assertFalse(screening.isAfterScreening(LocalDateTime.of(2021, 1, 1, 11, 0)))
    }
}