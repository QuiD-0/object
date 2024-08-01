package com.quid.spring.cinema.ticketOffice.domain

import com.quid.spring.cinema.movieSchedule.domain.MovieScheduleTable

data class Theater(
    val id: Long,
    val name: String,
    val movieSchedule: MovieScheduleTable
) {
}