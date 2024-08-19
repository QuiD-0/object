package com.quid.spring.multiplex.cinema.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.math.BigDecimal
import java.time.LocalDateTime

class BoxOfficeTest{

    @Test
    fun constructor() {
        val boxOffice = BoxOffice(1, BigDecimal(1000))
        assertEquals(1, boxOffice.id)
    }

    @Test
    fun addSchedule() {
        val boxOffice = BoxOffice(1, BigDecimal(1000))
        val schedule = MovieSchedule(1, 1, 1, 1, LocalDateTime.now(), LocalDateTime.now().plusHours(2))

        val result = boxOffice.addSchedule(schedule)

        assertEquals(1, result.movieSchedule.size)
    }

}