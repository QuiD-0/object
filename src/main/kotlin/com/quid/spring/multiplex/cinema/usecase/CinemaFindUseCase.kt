package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
import org.springframework.stereotype.Service

@Service
class CinemaFindUseCase(
    private val cinema: CinemaReadRepository,
) {
    fun findCinemaBy(id: Long) = cinema.findBy(id)

    fun checkDuplicateName(name: String) {
        takeIf { cinema.existsBy(name) }
            ?.let { throw IllegalArgumentException("Cinema already exists with name: $name") }
    }
}