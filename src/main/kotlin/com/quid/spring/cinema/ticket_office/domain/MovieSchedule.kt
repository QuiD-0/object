package com.quid.spring.cinema.ticket_office.domain

import java.time.LocalDateTime

data class MovieSchedule(
    val id: Long,
    val movieId: Long,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
) {
}