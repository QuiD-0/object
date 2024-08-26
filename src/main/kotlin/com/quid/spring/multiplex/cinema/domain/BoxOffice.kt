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

    fun reserve(movieScheduleId: Long, count: Int): BoxOffice {
        val schedule = movieSchedule.find { it.id == movieScheduleId }
            ?: throw IllegalArgumentException("Schedule not found")

        val updatedSchedule = schedule.reserve(count)
        val updatedSchedules = movieSchedule.map {
            if (it.id == movieScheduleId) updatedSchedule else it
        }

        return this.copy(movieSchedule = updatedSchedules)
    }

    fun getTotalTicketPrice(count: Int): BigDecimal {
        return ticketPrice * BigDecimal(count)
    }
}
