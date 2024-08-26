package com.quid.spring.multiplex.cinema.domain

import com.quid.spring.multiplex.global.vo.Money
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class BoxOfficeTest {

    @Test
    fun constructor() {
        val boxOffice = BoxOffice(1, Money(1000))
        assertEquals(1, boxOffice.id)
    }

    @Test
    fun addSchedule() {
        val boxOffice = BoxOffice(1, Money(1000))
        val schedule = MovieSchedule(1, 1, 1, 1, LocalDateTime.now(), LocalDateTime.now().plusHours(2))

        val result = boxOffice.addSchedule(schedule)

        assertEquals(1, result.movieSchedule.size)
    }

}