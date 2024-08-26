package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.*
import org.springframework.stereotype.Service

@Service
class CinemaFindUseCase(
    private val repository: CinemaReadRepository,
) {
    fun findBy(id: Long) = repository.findById(id)

    fun checkDuplicateName(name: String) {
        takeIf { repository.existsByName(name) }
            ?.let { throw IllegalArgumentException("Cinema already exists with name: $name") }
    }

    fun findByTheaterId(theaterId: Long): Cinema = repository.findByTheaterId(theaterId)
    fun findMovieScheduleBy(scheduleId: Long): MovieSchedule = repository.findMovieScheduleBy(scheduleId)
    fun findTheaterBy(theaterId: Long): Theater = repository.findTheaterBy(theaterId)
    fun findBoxOfficeBySchedule(movieScheduleId: Long): BoxOffice = repository.findBoxOfficeBySchedule(movieScheduleId)
}