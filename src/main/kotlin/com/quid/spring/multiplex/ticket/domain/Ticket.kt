package com.quid.spring.multiplex.ticket.domain

import com.quid.spring.multiplex.cinema.domain.MovieSchedule
import com.quid.spring.multiplex.reservation.domain.Reservation
import java.math.BigDecimal
import java.time.LocalDateTime

data class Ticket(
    val id: Long? = null,
    val reservationId: Long,
    val theaterName: String,
    val movieName: String,
    val seat: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val price: BigDecimal,
)

fun issueTicket(
    reservation: Reservation,
    movieSchedule: MovieSchedule,
    movieTitle: String,
    theaterName: String
): Ticket {
    return Ticket(
        id = null,
        reservationId = reservation.id!!,
        theaterName = theaterName,
        movieName = movieTitle,
        seat = mockSeat(reservation.count),
        startTime = movieSchedule.startTime,
        endTime = movieSchedule.endTime,
        price = reservation.totalPrice
    )
}

private fun mockSeat(count: Int): String {
    return (1..count).joinToString(",") { "A$it" }
}