package com.quid.spring.multiplex.reservation.infra.repository.entity

import com.quid.spring.multiplex.global.vo.Money
import com.quid.spring.multiplex.reservation.domain.Reservation

fun toEntity(entity: Reservation): ReservationEntity = ReservationEntity(
    id = entity.id,
    userId = entity.userId,
    scheduleId = entity.scheduleId,
    count = entity.count,
    totalPrice = entity.totalPrice.amount,
    currency = entity.totalPrice.currency,
    status = entity.status,
    ticketIssued = entity.ticketIssued,
    createdAt = entity.createdAt,
    updatedAt = entity.updatedAt
)

fun toReservation(entity: ReservationEntity): Reservation = Reservation(
    id = entity.id,
    userId = entity.userId,
    scheduleId = entity.scheduleId,
    count = entity.count,
    totalPrice = Money(entity.totalPrice, entity.currency),
    status = entity.status,
    ticketIssued = entity.ticketIssued,
    createdAt = entity.createdAt,
    updatedAt = entity.updatedAt
)