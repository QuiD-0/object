package com.quid.spring.multiplex.reservation.infra.repository.entity

import com.quid.spring.multiplex.global.vo.Currency
import com.quid.spring.multiplex.reservation.domain.OrderStatus
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "RESERVATION")
class ReservationEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "USER_ID")
    val userId: Long,
    @Column(name = "SCHEDULE_ID")
    val scheduleId: Long,
    @Column(name = "COUNT")
    val count: Int,
    @Column(name = "TOTAL_PRICE")
    val totalPrice: BigDecimal,
    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    val currency: Currency,
    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    val status: OrderStatus,
    @Column(name = "TICKET_ISSUED")
    val ticketIssued: Boolean,
    @Column(name = "CREATED_AT")
    val createdAt: LocalDateTime,
    @Column(name = "UPDATED_AT")
    val updatedAt: LocalDateTime
)