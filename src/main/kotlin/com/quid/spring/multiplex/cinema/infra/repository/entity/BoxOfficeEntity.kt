package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction
import java.math.BigDecimal

@Entity
@Table(name = "BOX_OFFICE")
@SQLDelete(sql = "UPDATE BOX_OFFICE SET DELETED = true WHERE ID = ?")
@SQLRestriction("DELETED = false")
class BoxOfficeEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "TICKET_PRICE")
    val ticketPrice: BigDecimal,
    @JoinColumn(name = "BOX_OFFICE_ID", nullable = false, updatable = false)
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val movieSchedule: List<MovieScheduleEntity>,
    @Column(name = "DELETED")
    val deleted: Boolean = false
)
