package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "CINEMA")
@SQLDelete(sql = "UPDATE CINEMA SET DELETED = true WHERE ID = ?")
@SQLRestriction("DELETED = false")
class CinemaEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "LOCATION")
    val location: String,
    @JoinColumn(name = "CINEMA_ID", nullable = false, updatable = false)
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val theaters: List<TheaterEntity>,
    @JoinColumn(name = "BOX_OFFICE_ID")
    @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val boxOffice: BoxOfficeEntity,
    @Column(name = "DELETED")
    val deleted: Boolean = false
)

