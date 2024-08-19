package com.quid.spring.multiplex.reservation.domain

data class Ticket(
    val id: Long,
    val reservationId: Long,
    val theaterName: String,
    val movieName: String,
    val seat: String,
    val startTime: String,
    val endTime: String,
)