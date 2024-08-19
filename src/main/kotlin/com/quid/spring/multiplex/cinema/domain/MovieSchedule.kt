package com.quid.spring.multiplex.cinema.domain

import java.time.LocalDateTime

data class MovieSchedule(
    val id: Long?,
    val movieId: Long,
    val theaterId: Long,
    val capacity: Int,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
) {
}