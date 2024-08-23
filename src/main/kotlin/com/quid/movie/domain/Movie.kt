package movie.domain

import java.time.Duration

data class Movie(
    val title: String,
    val runningTime: Duration
)