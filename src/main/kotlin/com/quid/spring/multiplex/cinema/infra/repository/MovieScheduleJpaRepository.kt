package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.infra.repository.entity.MovieScheduleEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MovieScheduleJpaRepository : JpaRepository<MovieScheduleEntity, Long> {
}