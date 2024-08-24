package com.quid.spring.multiplex.reservation.usecase

import com.quid.spring.multiplex.cinema.usecase.CinemaFindUseCase
import com.quid.spring.multiplex.cinema.usecase.CinemaUpdateUseCase
import com.quid.spring.multiplex.reservation.domain.ReserveWriteRepository
import com.quid.spring.multiplex.reservation.domain.init
import com.quid.spring.multiplex.reservation.infra.controller.request.MovieReserveRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class ReserveMovieUseCase(
    private val cinemaFind: CinemaFindUseCase,
    private val cinemaMerge: CinemaUpdateUseCase,
    private val reserveRepository: ReserveWriteRepository,
    private val transactionTemplate: TransactionTemplate
) {
    fun invoke(request: MovieReserveRequest): Long {
        val cinema = cinemaFind.findBySchedule(request.movieScheduleId)

        val reservation = init(request)
            .let { reserveRepository.save(it) }

        val totalAmount = cinema.getTotalTicketPrice(request.count)
        val confirm = reservation.confirm(totalAmount)

        try {
            val updatedCinema = cinema.reserve(request.movieScheduleId, request.count)

            transactionTemplate.execute({
                cinemaMerge.invoke(updatedCinema)
                reserveRepository.save(confirm)
            })
        } catch (e: Exception) {
            val cancel = reservation.cancel()
            reserveRepository.save(cancel)
            throw e
        }

        return reservation.id!!
    }
}