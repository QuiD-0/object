package com.quid.spring.multiplex.ticket.infra.repository

import com.quid.spring.multiplex.ticket.domain.Ticket
import com.quid.spring.multiplex.ticket.domain.TicketWriteRepository
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
@Transactional
class TicketWriteRdbRepository(
    private val ticketJpaRepository: JpaRepository<TicketEntity, Long>
) : TicketWriteRepository {
    override fun save(ticket: Ticket): Ticket {
        return ticketJpaRepository.save(toEntity(ticket))
            .run { toTicket(this) }
    }
}