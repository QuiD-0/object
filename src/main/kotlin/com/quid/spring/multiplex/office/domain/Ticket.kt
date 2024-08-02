package com.quid.spring.multiplex.office.domain

data class Ticket(
    val id: Long,
    val theaterName: String,
    val movieName: String,
    val seat: String,
    val startTime: String,
    val endTime: String,
) {
}