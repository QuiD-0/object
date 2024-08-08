package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaRepository
import com.quid.spring.multiplex.cinema.infra.repository.entity.toCinema
import org.springframework.data.repository.findByIdOrNull

class CinemaRdbRepository(
    private val cinemaJpaRepository: CinemaJpaRepository
): CinemaRepository {
    override fun findBy(id: Long): Cinema {
        return cinemaJpaRepository.findByIdOrNull(id)
            ?.let { toCinema(it) }
            ?: throw IllegalArgumentException("Cinema not found with id: $id")
    }
}