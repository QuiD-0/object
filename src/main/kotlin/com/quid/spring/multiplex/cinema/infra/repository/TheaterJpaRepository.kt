package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.infra.repository.entity.TheaterEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TheaterJpaRepository: JpaRepository<TheaterEntity, Long> {
}