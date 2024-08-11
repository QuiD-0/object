package com.quid.spring.multiplex.cinema.infra.controller.request

import com.quid.spring.multiplex.cinema.domain.MovieSchedule
import java.time.Duration
import java.time.LocalDateTime

data class AssignScheduleRequest(
    val cinemaId: Long,
    val movieId: Long,
    val startTime: LocalDateTime,
) {
    fun getSchedule(duration: Long): MovieSchedule {
        return MovieSchedule(
            id = null,
            movieId = movieId,
            startTime = startTime,
            endTime = startTime.plus(Duration.ofMinutes(duration))
        )
    }
}