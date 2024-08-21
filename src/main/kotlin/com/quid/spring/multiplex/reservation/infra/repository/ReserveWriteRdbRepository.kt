package com.quid.spring.multiplex.reservation.infra.repository

import com.quid.spring.multiplex.reservation.domain.Reservation
import com.quid.spring.multiplex.reservation.domain.ReserveWriteRepository
import com.quid.spring.multiplex.reservation.infra.repository.entity.toReservation
import com.quid.spring.multiplex.reservation.infra.repository.entity.toEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
@Transactional
class ReserveWriteRdbRepository(
    private val reserveJpaRepository: ReserveJpaRepository
) : ReserveWriteRepository {
    override fun save(reservation: Reservation): Reservation = reserveJpaRepository.save(toEntity(reservation))
        .run { toReservation(this) }
}