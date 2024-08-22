package com.quid.spring.multiplex.reservation.usecase

import com.quid.spring.multiplex.reservation.domain.ReserveReadRepository
import org.springframework.stereotype.Service

@Service
class IssueTicketUseCase(
    private val reserveFind: ReserveReadRepository
) {
    fun invoke(reservationId: Long) {
        val reservation = reserveFind.findBy(reservationId)
    }
}