package com.quid.spring.multiplex.cinema.infra.repository.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "MOVIE_SCHEDULE")
class MovieScheduleEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    @Column(name = "MOVIE_ID")
    val movieId: Long,
    @Column(name = "START_TIME")
    val startTime: LocalDateTime,
    @Column(name = "END_TIME")
    val endTime: LocalDateTime
)
