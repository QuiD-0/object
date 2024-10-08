package com.quid.spring.multiplex.cinema.domain

data class Theater(
    val id: Long?,
    val name: String,
    val location: String,
    val capacity: Int,
) {
    init {
        if (capacity <= 0) {
            throw IllegalArgumentException("Capacity must be greater than 0")
        }
    }
}