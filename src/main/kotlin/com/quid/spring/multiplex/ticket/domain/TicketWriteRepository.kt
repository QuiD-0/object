package com.quid.spring.multiplex.ticket.domain

interface TicketWriteRepository {
    fun save(ticket: Ticket): Ticket
}