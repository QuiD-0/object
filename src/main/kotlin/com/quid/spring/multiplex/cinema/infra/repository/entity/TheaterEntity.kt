package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*

@Entity
@Table(name = "THEATER")
class TheaterEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "LOCATION")
    val location: String,
    @Column(name = "CAPACITY")
    val capacity: Int
) {
}
