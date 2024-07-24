package movie.domain

import java.time.Duration
import java.time.LocalDateTime

data class Ticket(
    val movieName: String,
    val screenDateTime: LocalDateTime,
    val duration: Duration,
    val sequence: Int,
) {
    constructor(screening: Screening) : this(
        screening.movie.title,
        screening.screenDateTime,
        screening.movie.runningTime,
        screening.sequence
    )

    val playTime: String
        get() = "${screenDateTime.toLocalTime()} ~ ${screenDateTime.toLocalTime().plusMinutes(duration.toMinutes())}"

}