package com.quid.spring.multiplex.office.domain

import java.time.LocalDateTime

data class MovieSchedule(
    val id: Long,
    val movieId: Long,
    val theater: Theater,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
) {
}