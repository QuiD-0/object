package com.quid.spring.multiplex.reservation.domain

data class Reservation (
    val id: Long,
    val userId: Long,
    val scheduleId: Long,
    val amount : Long,
    val totalPrice: Long,
    val status: OrderStatus,
    val createdAt: Long,
    val updatedAt: Long
)

