package com.quid.spring.multiplex.order.domain

data class Ticket(
    val id: Long,
    val theaterName: String,
    val movieName: String,
    val seat: String,
    val startTime: String,
    val endTime: String,
)