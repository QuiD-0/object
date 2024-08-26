package com.quid.spring.multiplex.ticket.infra.repository

import com.quid.spring.multiplex.global.vo.Money
import com.quid.spring.multiplex.ticket.domain.Ticket

fun toEntity(ticket: Ticket): TicketEntity {
    return TicketEntity(
        id = ticket.id,
        reservationId = ticket.reservationId,
        theaterName = ticket.theaterName,
        movieName = ticket.movieName,
        seat = ticket.seat,
        startTime = ticket.startTime,
        endTime = ticket.endTime,
        price = ticket.price.amount,
        currency = ticket.price.currency
    )
}

fun toTicket(ticketEntity: TicketEntity): Ticket {
    return Ticket(
        id = ticketEntity.id,
        reservationId = ticketEntity.reservationId,
        theaterName = ticketEntity.theaterName,
        movieName = ticketEntity.movieName,
        seat = ticketEntity.seat,
        startTime = ticketEntity.startTime,
        endTime = ticketEntity.endTime,
        price = Money(ticketEntity.price, ticketEntity.currency)
    )
}