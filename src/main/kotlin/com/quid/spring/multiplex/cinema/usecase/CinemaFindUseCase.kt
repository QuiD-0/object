package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
import org.springframework.stereotype.Service

@Service
class CinemaFindUseCase(
    private val repository: CinemaReadRepository,
) {
    fun findCinemaBy(id: Long) = repository.findBy(id)

    fun checkDuplicateName(name: String) {
        takeIf { repository.existsBy(name) }
            ?.let { throw IllegalArgumentException("Cinema already exists with name: $name") }
    }
}