package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDateTime

@Entity
@Table(name = "MOVIE_SCHEDULE")
@SQLDelete(sql = "UPDATE MOVIE_SCHEDULE SET DELETED = true WHERE ID = ?")
@SQLRestriction("DELETED = false")
class MovieScheduleEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "MOVIE_ID")
    val movieId: Long,
    @Column(name = "THEATER_ID")
    val theaterId: Long,
    @Column(name = "CAPACITY")
    val capacity: Int,
    @Column(name = "START_TIME")
    val startTime: LocalDateTime,
    @Column(name = "END_TIME")
    val endTime: LocalDateTime,
    @Column(name = "DELETED")
    val deleted: Boolean = false
)
