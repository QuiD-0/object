package com.quid.spring.multiplex.reservation.infra.repository

import com.quid.spring.multiplex.reservation.domain.Reservation
import com.quid.spring.multiplex.reservation.domain.ReserveWriteRepository
import com.quid.spring.multiplex.reservation.infra.repository.entity.toEntity
import org.springframework.stereotype.Repository

@Repository
class ReserveWriteRdbRepository(
    private val reserveJpaRepository: ReserveJpaRepository
) : ReserveWriteRepository {
    override fun save(reservation: Reservation): Long = reserveJpaRepository.save(toEntity(reservation)).id!!
}