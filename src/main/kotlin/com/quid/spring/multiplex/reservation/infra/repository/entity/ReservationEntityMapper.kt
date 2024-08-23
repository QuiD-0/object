package com.quid.spring.multiplex.reservation.infra.repository.entity

import com.quid.spring.multiplex.reservation.domain.Reservation

fun toEntity(reservation: Reservation): ReservationEntity = ReservationEntity(
    id = reservation.id,
    userId = reservation.userId,
    scheduleId = reservation.scheduleId,
    count = reservation.count,
    totalPrice = reservation.totalPrice,
    status = reservation.status,
    ticketIssued = reservation.ticketIssued,
    createdAt = reservation.createdAt,
    updatedAt = reservation.updatedAt
)

fun toReservation(reservationEntity: ReservationEntity): Reservation = Reservation(
    id = reservationEntity.id,
    userId = reservationEntity.userId,
    scheduleId = reservationEntity.scheduleId,
    count = reservationEntity.count,
    totalPrice = reservationEntity.totalPrice,
    status = reservationEntity.status,
    ticketIssued = reservationEntity.ticketIssued,
    createdAt = reservationEntity.createdAt,
    updatedAt = reservationEntity.updatedAt
)