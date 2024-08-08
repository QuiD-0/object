package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
import org.springframework.stereotype.Service

@Service
class CinemaFind(
    private val cinema: CinemaReadRepository,
) {
    fun findCinema(id: Long) = cinema.findBy(id)
}