package com.quid.spring.cinema.movieSchedule.domain

import com.quid.spring.cinema.movie.domain.Movie
import java.time.LocalDateTime

data class MovieSchedule(
    val movie: Movie,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime
)