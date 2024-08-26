package com.quid.spring.multiplex.cinema.domain

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
}