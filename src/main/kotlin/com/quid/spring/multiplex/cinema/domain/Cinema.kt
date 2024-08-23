package com.quid.spring.multiplex.cinema.domain

import java.math.BigDecimal

data class Cinema(
    val id: Long?,
    val name: String,
    val location: String,
    val theaters: List<Theater>,
    val boxOffice: BoxOffice
) {
    fun assignSchedule(schedule: MovieSchedule): Cinema {
        return this.copy(boxOffice = boxOffice.addSchedule(schedule))
    }

    fun checkRegistered() {
        if (id == null) {
            throw IllegalStateException("Cinema is not registered")
        }
    }

    fun getCapacity(theaterId: Long): Int {
        return theaters.find { it.id == theaterId }?.capacity
            ?: throw IllegalArgumentException("Theater not found")
    }

    fun getTotalTicketPrice(count: Int): BigDecimal {
        return boxOffice.ticketPrice.multiply(BigDecimal(count))
    }

    fun reserve(movieScheduleId: Long, count: Int): Cinema {
        return this.copy(boxOffice = boxOffice.reserve(movieScheduleId, count))
    }

    fun getMovieId(scheduleId: Long): Long {
        return boxOffice.getMovieId(scheduleId)
    }
}