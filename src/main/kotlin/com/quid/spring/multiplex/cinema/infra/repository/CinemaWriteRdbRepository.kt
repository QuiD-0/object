package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.domain.BoxOffice
import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import com.quid.spring.multiplex.cinema.infra.repository.entity.toBoxOffice
import com.quid.spring.multiplex.cinema.infra.repository.entity.toCinema
import com.quid.spring.multiplex.cinema.infra.repository.entity.toEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Repository

@Repository
@Transactional
class CinemaWriteRdbRepository(
    private val cinemaJpaRepository: CinemaJpaRepository,
    private val boxOfficeJpaRepository: BoxOfficeJpaRepository
) : CinemaWriteRepository {
    override fun save(cinema: Cinema): Cinema {
        return cinemaJpaRepository.save(toEntity(cinema))
            .run { toCinema(this) }
    }

    override fun save(boxOffice: BoxOffice): BoxOffice {
        return boxOfficeJpaRepository.save(toEntity(boxOffice))
            .run { toBoxOffice(this) }
    }

    override fun deleteById(id: Long) {
        cinemaJpaRepository.deleteById(id)
    }
}