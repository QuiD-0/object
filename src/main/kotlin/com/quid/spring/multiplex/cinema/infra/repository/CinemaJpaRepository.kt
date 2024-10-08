package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.infra.repository.entity.CinemaEntity
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface CinemaJpaRepository : JpaRepository<CinemaEntity, Long> {
    fun existsByName(name: String): Boolean

    @EntityGraph(attributePaths = ["boxOffice", "theaters"])
    fun findByBoxOffice_MovieScheduleId(movieScheduleId: Long): CinemaEntity?

    @EntityGraph(attributePaths = ["boxOffice", "theaters"])
    fun findByTheatersId(theaterId: Long): CinemaEntity?
}