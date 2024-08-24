package com.quid.spring.multiplex.cinema.domain

import com.quid.spring.multiplex.movie.domain.Movie
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

    fun getTheaterIdBySchedule(scheduleId: Long): Long {
        return movieSchedule.find { it.id == scheduleId }
            ?.theaterId
            ?: throw IllegalArgumentException("Schedule not found")
    }

    fun findMovieIdBySchedule(scheduleId: Long): Long {
        return movieSchedule.find { it.id == scheduleId }
            ?.movieId
            ?: throw IllegalArgumentException("Schedule not found")
    }
}
