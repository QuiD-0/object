package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.infra.repository.entity.BoxOfficeEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BoxOfficeJpaRepository: JpaRepository<BoxOfficeEntity, Long> {
    fun findByMovieScheduleId(movieScheduleId: Long): BoxOfficeEntity?
}