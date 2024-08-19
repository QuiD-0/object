package com.quid.spring.multiplex.cinema.domain

import java.math.BigDecimal

data class BoxOffice(
    val id: Long?,
    val ticketPrice: BigDecimal,
    val movieSchedule: List<MovieSchedule> = emptyList(),
) {
    fun addSchedule(schedule: MovieSchedule): BoxOffice {
        return this.copy(movieSchedule = movieSchedule + schedule)
    }

    fun findTheaterId(movieScheduleId: Long): Long {
        return movieSchedule.find { it.id == movieScheduleId }?.theaterId
            ?: throw IllegalArgumentException("Movie schedule not found")
    }
}
