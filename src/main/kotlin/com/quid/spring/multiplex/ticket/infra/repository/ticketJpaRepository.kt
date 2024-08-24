package com.quid.spring.multiplex.ticket.infra.repository

import org.springframework.data.jpa.repository.JpaRepository

interface ticketJpaRepository : JpaRepository<TicketEntity, Long> {
}