package com.quid.spring.multiplex.ticket.domain

import java.math.BigDecimal
import java.time.LocalDateTime

data class Ticket(
    val id: Long,
    val reservationId: Long,
    val theaterName: String,
    val movieName: String,
    val seat: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val price: BigDecimal,
)