package com.quid.spring.multiplex.cinema.infra.controller.request

import com.quid.spring.multiplex.cinema.domain.MovieSchedule
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class AssignScheduleRequest(
    val cinemaId: Long,
    val movieId: Long,
    val theaterId: Long,
    val startDate: LocalDate,
    val startTime: LocalTime
) {
    private val startDateTime: LocalDateTime
        get() = LocalDateTime.of(startDate, startTime)

    fun toSchedule(duration: Long, capacity: Int): MovieSchedule {
        return MovieSchedule(
            id = null,
            movieId = movieId,
            theaterId = theaterId,
            capacity = capacity,
            startTime = startDateTime,
            endTime = startDateTime.plus(Duration.ofMinutes(duration)),
        )
    }
}