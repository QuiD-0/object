package com.quid.spring.multiplex.reservation

import com.quid.spring.multiplex.reservation.domain.Reservation
import com.quid.spring.multiplex.reservation.domain.ReserveReadRepository
import org.springframework.stereotype.Service

@Service
class ReserveFindUseCase(
    private val reserveReadRepository: ReserveReadRepository
) {
    fun findBy(reservationId: Long): Reservation {
        return reserveReadRepository.findBy(reservationId)
    }
}