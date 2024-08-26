package com.quid.spring.multiplex.reservation.domain

import com.quid.spring.multiplex.global.vo.Money
import com.quid.spring.multiplex.reservation.domain.OrderStatus.*
import com.quid.spring.multiplex.reservation.infra.controller.request.MovieReserveRequest
import java.time.LocalDateTime

data class Reservation(
    val id: Long? = null,
    val userId: Long,
    val scheduleId: Long,
    val count: Int,
    val totalPrice: Money,
    val status: OrderStatus,
    val ticketIssued: Boolean,
    val createdAt: LocalDateTime,
    val updatedAt: LocalDateTime
) {
    fun confirm(totalAmount: Money) = this.copy(
        totalPrice = totalAmount,
        status = CONFIRMED,
        updatedAt = LocalDateTime.now()
    )

    fun cancel(): Reservation = this.copy(
        status = CANCELED,
        updatedAt = LocalDateTime.now()
    )

    fun issueComplete() = this.copy(
        ticketIssued = true,
        updatedAt = LocalDateTime.now()
    )
}

fun init(request: MovieReserveRequest) = Reservation(
    userId = request.userId,
    scheduleId = request.movieScheduleId,
    count = request.count,
    totalPrice = Money(0),
    status = PENDING,
    ticketIssued = false,
    createdAt = LocalDateTime.now(),
    updatedAt = LocalDateTime.now()
)
