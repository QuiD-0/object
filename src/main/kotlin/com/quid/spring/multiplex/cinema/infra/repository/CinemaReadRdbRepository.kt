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

    override fun findById(id: Long): Cinema {
        return cinemaJpaRepository.findByIdOrNull(id)
            ?.let { toCinema(it) }
            ?: throw IllegalArgumentException("Cinema not found with id: $id")
    }

    override fun existsByName(name: String): Boolean {
        return cinemaJpaRepository.existsByName(name)
    }

    override fun findBySchedule(movieScheduleId: Long): Cinema {
        return cinemaJpaRepository.findByBoxOffice_MovieScheduleId(movieScheduleId)
            ?.let { toCinema(it) }
            ?: throw IllegalArgumentException("Cinema not found with movie schedule id: $movieScheduleId")
    }

    override fun findByTheaterId(theaterId: Long): Cinema {
        return cinemaJpaRepository.findByTheatersId(theaterId)
            ?.let { toCinema(it) }
            ?: throw IllegalArgumentException("Cinema not found with theater id: $theaterId")
    }
}