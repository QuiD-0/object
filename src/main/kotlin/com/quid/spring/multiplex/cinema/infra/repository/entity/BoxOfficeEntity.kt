package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(name = "BOX_OFFICE")
class BoxOfficeEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "TICKET_PRICE")
    val ticketPrice: BigDecimal,
    @JoinColumn(name = "BOX_OFFICE_ID")
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val movieSchedule: List<MovieScheduleEntity>,
)
