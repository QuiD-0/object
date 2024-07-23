package movie

import java.time.LocalDateTime

data class Screening(
    val movie: Movie,
    val sequence: Int,
    val price: Money,
    val screenDateTime: LocalDateTime
) {
    fun isSequence(sequence: Int): Boolean = this.sequence == sequence

    fun isAfterScreening(screenDateTime: LocalDateTime): Boolean = this.screenDateTime.isAfter(screenDateTime)

    fun getStartTime(): LocalDateTime = screenDateTime

    fun getEndTime(): LocalDateTime = screenDateTime.plusMinutes(movie.runningTime.toMinutes())
}

