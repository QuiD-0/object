package com.quid.spring.multiplex.reservation.usecase

import com.quid.spring.multiplex.reservation.domain.Reservation
import com.quid.spring.multiplex.reservation.domain.ReserveWriteRepository
import org.springframework.stereotype.Service

@Service
class ReserveSaveUseCase(
    private val reserveWrite: ReserveWriteRepository
) {
    fun invoke(reserve: Reservation): Reservation {
        return reserveWrite.save(reserve)
    }
}