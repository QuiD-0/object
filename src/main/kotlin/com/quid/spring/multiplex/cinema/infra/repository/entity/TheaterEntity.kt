package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction

@Entity
@Table(name = "THEATER")
@SQLDelete(sql = "UPDATE THEATER SET DELETED = true WHERE ID = ?")
@SQLRestriction("DELETED = false")
class TheaterEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "NAME")
    val name: String,
    @Column(name = "LOCATION")
    val location: String,
    @Column(name = "CAPACITY")
    val capacity: Int,
    @Column(name = "DELETED")
    val deleted: Boolean = false
)
