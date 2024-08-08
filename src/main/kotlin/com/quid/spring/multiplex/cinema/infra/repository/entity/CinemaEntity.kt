package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "CINEMA")
class CinemaEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "LOCATION")
    val location: String,
    @JoinColumn(name = "CINEMA_ID")
    @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val theaters: List<TheaterEntity>,
    @JoinColumn(name = "CINEMA_ID")
    @OneToOne(fetch = FetchType.EAGER, cascade = [CascadeType.ALL], orphanRemoval = true)
    val boxOffice: BoxOfficeEntity
) {
}

