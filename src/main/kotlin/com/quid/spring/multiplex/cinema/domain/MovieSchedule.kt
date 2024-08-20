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
    init {
        require(capacity > 0) { "Capacity must be greater than 0" }
    }

    fun reserve(count: Int): MovieSchedule {
        require(startTime.isAfter(LocalDateTime.now())) { "Cannot reserve for past schedule" }
        return this.copy(capacity = capacity - count)
    }
}