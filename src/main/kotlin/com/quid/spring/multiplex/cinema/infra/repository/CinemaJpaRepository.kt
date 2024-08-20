package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.infra.repository.entity.CinemaEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface CinemaJpaRepository : JpaRepository<CinemaEntity, Long> {
    fun existsByName(name: String): Boolean
    fun findByBoxOffice_MovieScheduleId(movieScheduleId: Long): CinemaEntity?
    @Query("SELECT c FROM CinemaEntity c JOIN c.theaters t WHERE t.id = :theaterId")
    fun findByTheatersId(theaterId: Long): CinemaEntity?
}