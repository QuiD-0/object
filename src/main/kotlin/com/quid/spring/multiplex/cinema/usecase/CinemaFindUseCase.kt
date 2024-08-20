package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
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

    fun findBySchedule(movieScheduleId: Long): Cinema = repository.findBySchedule(movieScheduleId)
    fun findByTheaterId(theaterId: Long): Cinema = repository.findByTheaterId(theaterId)
}