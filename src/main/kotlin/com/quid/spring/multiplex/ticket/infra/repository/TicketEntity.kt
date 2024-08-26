package com.quid.spring.multiplex.ticket.infra.repository

import com.quid.spring.multiplex.global.vo.Currency
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "TICKET")
class TicketEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name = "RESERVATION_ID")
    val reservationId: Long,
    @Column(name = "THEATER_NAME")
    val theaterName: String,
    @Column(name = "MOVIE_NAME")
    val movieName: String,
    @Column(name = "SEAT")
    val seat: String,
    @Column(name = "START_TIME")
    val startTime: LocalDateTime,
    @Column(name = "END_TIME")
    val endTime: LocalDateTime,
    @Column(name = "PRICE")
    val price: BigDecimal,
    @Column(name = "CURRENCY")
    @Enumerated(EnumType.STRING)
    val currency: Currency
)