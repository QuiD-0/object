package com.quid.spring.cinema.domain

data class Theater(
    val id: Long,
    val name: String,
    val movieSchedule: MovieSchedule
) {
}


