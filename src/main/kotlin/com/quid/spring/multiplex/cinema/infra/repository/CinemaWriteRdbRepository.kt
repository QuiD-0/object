package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import com.quid.spring.multiplex.cinema.infra.repository.entity.toCinema
import com.quid.spring.multiplex.cinema.infra.repository.entity.toEntity
import org.springframework.stereotype.Repository

@Repository
class CinemaWriteRdbRepository(
    private val cinemaJpaRepository: CinemaJpaRepository
) : CinemaWriteRepository {
    override fun save(cinema: Cinema): Cinema {
        return cinemaJpaRepository.save(toEntity(cinema))
            .run { toCinema(this) }
    }
}