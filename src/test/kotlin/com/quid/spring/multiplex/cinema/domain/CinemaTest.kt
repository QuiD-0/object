package com.quid.spring.multiplex.cinema.domain

import com.quid.spring.multiplex.global.vo.Money
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class CinemaTest {

    @Test
    fun constructor() {
        val theater = Theater(1, "Theater 1", "1F-1", 100)
        val boxOffice = BoxOffice(1, Money(1000))

        val cinema = Cinema(1, "Cinema 1", "Address 1", listOf(theater), boxOffice)
        assertEquals(1, cinema.id)
    }

    @Test
    fun assignSchedule() {
        val theater = Theater(1, "Theater 1", "1F-1", 100)
        val boxOffice = BoxOffice(1, Money(1000))
        val cinema = Cinema(1, "Cinema 1", "Address 1", listOf(theater), boxOffice)
        val schedule = MovieSchedule(1, 1, 1, 1, LocalDateTime.now(), LocalDateTime.now().plusHours(2))

        val result = cinema.assignSchedule(schedule)

        assertEquals(1, result.boxOffice.movieSchedule.size)
    }

    @Test
    fun checkRegistered() {
        val theater = Theater(1, "Theater 1", "1F-1", 100)
        val boxOffice = BoxOffice(1, Money(1000))
        val cinema = Cinema(null, "Cinema 1", "Address 1", listOf(theater), boxOffice)

        assertThrows(IllegalStateException::class.java) {
            cinema.checkRegistered()
        }
    }

}