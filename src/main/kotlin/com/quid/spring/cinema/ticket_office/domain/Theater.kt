package com.quid.spring.cinema.ticket_office.domain

data class Theater(
    val id: Long,
    val cinemaId: Long,
    val name: String,
    val movieSchedule: List<MovieSchedule>
) {
}