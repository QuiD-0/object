package com.quid.spring.multiplex.movie.infra.repository

import com.quid.spring.multiplex.movie.infra.repository.entity.MovieEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MovieJpaRepository : JpaRepository<MovieEntity, Long> {
    fun findAllByDirector(director: String): List<MovieEntity>
}