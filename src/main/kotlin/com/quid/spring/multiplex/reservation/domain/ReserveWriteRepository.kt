package com.quid.spring.multiplex.reservation.domain

interface ReserveWriteRepository {
    fun save(reservation: Reservation): Reservation
}