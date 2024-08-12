package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
import com.quid.spring.multiplex.cinema.infra.repository.entity.toCinema
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
class CinemaReadRdbRepository(
    private val cinemaJpaRepository: CinemaJpaRepository
) : CinemaReadRepository {

    override fun findBy(id: Long): Cinema {
        return cinemaJpaRepository.findByIdOrNull(id)
            ?.let { toCinema(it) }
            ?: throw IllegalArgumentException("Cinema not found with id: $id")
    }

    override fun existsBy(name: String): Boolean {
        return cinemaJpaRepository.existsByName(name)
    }
}