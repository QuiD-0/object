package com.quid.spring.multiplex.reservation.domain

interface ReserveReadRepository {
    fun findBy(reservationId: Long): Reservation
}