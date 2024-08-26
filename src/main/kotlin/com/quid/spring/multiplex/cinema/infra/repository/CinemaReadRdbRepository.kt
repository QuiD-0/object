package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.domain.*
import com.quid.spring.multiplex.cinema.infra.repository.entity.toBoxOffice
import com.quid.spring.multiplex.cinema.infra.repository.entity.toCinema
import com.quid.spring.multiplex.cinema.infra.repository.entity.toMovieSchedule
import com.quid.spring.multiplex.cinema.infra.repository.entity.toTheater
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
@Transactional(readOnly = true)
class CinemaReadRdbRepository(
    private val cinemaJpaRepository: CinemaJpaRepository,
    private val movieScheduleJpaRepository: MovieScheduleJpaRepository,
    private val theaterJpaRepository: TheaterJpaRepository,
    private val boxOfficeJpaRepository: BoxOfficeJpaRepository
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

    override fun findMovieScheduleBy(scheduleId: Long): MovieSchedule {
        return movieScheduleJpaRepository.findByIdOrNull(scheduleId)
            ?.let { toMovieSchedule(it) }
            ?: throw IllegalArgumentException("Movie schedule not found with id: $scheduleId")
    }

    override fun findTheaterBy(theaterId: Long): Theater {
        return theaterJpaRepository.findByIdOrNull(theaterId)
            ?.let { toTheater(it) }
            ?: throw IllegalArgumentException("Theater not found with id: $theaterId")
    }

    override fun findBoxOfficeBySchedule(movieScheduleId: Long): BoxOffice {
        return boxOfficeJpaRepository.findByMovieScheduleId(movieScheduleId)
            ?.let { toBoxOffice(it) }
            ?: throw IllegalArgumentException("Box office not found with movie schedule id: $movieScheduleId")
    }
}