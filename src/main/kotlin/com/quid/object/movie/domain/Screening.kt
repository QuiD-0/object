package movie.domain

import java.time.LocalDateTime

data class Screening(
    val movie: Movie,
    val sequence: Int,
    val price: Money,
    val seats: Seats,
    val screenDateTime: LocalDateTime
) {
    fun isSequence(sequence: Int): Boolean = this.sequence == sequence

    fun isAfterScreening(screenDateTime: LocalDateTime): Boolean = this.screenDateTime.isAfter(screenDateTime)

    fun getStartTime(): LocalDateTime = screenDateTime

    fun getEndTime(): LocalDateTime = screenDateTime.plusMinutes(movie.runningTime.toMinutes())

    fun getTotalAmount(audienceCount: Int): Money = price * audienceCount
    fun reserve(size: List<Customer>) {
        seats.reserve(size)
    }
}

