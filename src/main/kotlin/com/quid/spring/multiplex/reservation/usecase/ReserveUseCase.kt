package com.quid.spring.multiplex.reservation.usecase

import com.quid.spring.multiplex.cinema.usecase.CinemaFindUseCase
import com.quid.spring.multiplex.cinema.usecase.CinemaUpdateUseCase
import com.quid.spring.multiplex.reservation.domain.Ticket
import com.quid.spring.multiplex.reservation.infra.controller.request.MovieReserveRequest
import org.springframework.stereotype.Service

@Service
class ReserveUseCase(
    private val cinemaFind: CinemaFindUseCase,
    private val cinemaMerge: CinemaUpdateUseCase
) {
    fun invoke(request: MovieReserveRequest): Ticket {
        val cinema = cinemaFind.findBySchedule(request.movieScheduleId)
        return null as Ticket
    }
}