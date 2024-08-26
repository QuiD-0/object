package com.quid.spring.multiplex.ticket.infra.controller

import com.quid.spring.multiplex.ticket.domain.Ticket
import com.quid.spring.multiplex.ticket.usecase.IssueTicketUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/ticket")
class TicketController(
    private val ticket: IssueTicketUseCase
) {

    @PostMapping("/issue/{reservationId}")
    fun issueTicket(@PathVariable reservationId: Long): Ticket {
        return ticket.invoke(reservationId)
    }
}