package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.infra.repository.entity.CinemaEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CinemaJpaRepository: JpaRepository<CinemaEntity, Long> {
    fun existsByName(name: String): Boolean
}