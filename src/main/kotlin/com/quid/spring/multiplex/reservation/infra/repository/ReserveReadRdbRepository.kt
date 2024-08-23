package com.quid.spring.multiplex.reservation.infra.repository

import com.quid.spring.multiplex.reservation.domain.Reservation
import com.quid.spring.multiplex.reservation.domain.ReserveReadRepository
import com.quid.spring.multiplex.reservation.infra.repository.entity.toReservation
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ReserveReadRdbRepository(
    private val reserveJpaRepository: ReserveJpaRepository
) : ReserveReadRepository {
    override fun findBy(reservationId: Long): Reservation {
        return reserveJpaRepository.findByIdOrNull(reservationId)
            ?.let { toReservation(it) }
            ?: throw IllegalArgumentException("Reservation not found. reservationId: $reservationId")
    }
}