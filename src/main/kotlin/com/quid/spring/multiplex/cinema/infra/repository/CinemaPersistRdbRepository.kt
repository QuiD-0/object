package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.domain.*
import com.quid.spring.multiplex.cinema.infra.repository.entity.toEntity

class CinemaPersistRdbRepository(
    private val cinemaJpaRepository: CinemaJpaRepository
): CinemaPersistRepository {
    override fun save(cinema: Cinema): Long {
        return cinemaJpaRepository.save(toEntity(cinema)).id!!
    }
}