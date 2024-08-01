package com.quid.spring.cinema.domain

import java.time.LocalDateTime

data class MovieSchedule(
    val movie: Movie,
    val theater: Theater,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
)