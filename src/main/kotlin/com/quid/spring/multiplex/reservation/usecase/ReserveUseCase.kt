package com.quid.spring.multiplex.reservation.usecase

import com.quid.spring.multiplex.cinema.usecase.CinemaFindUseCase
import com.quid.spring.multiplex.cinema.usecase.CinemaUpdateUseCase
import com.quid.spring.multiplex.reservation.domain.ReserveWriteRepository
import com.quid.spring.multiplex.reservation.domain.Ticket
import com.quid.spring.multiplex.reservation.domain.init
import com.quid.spring.multiplex.reservation.infra.controller.request.MovieReserveRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.TransactionException
import org.springframework.transaction.support.TransactionTemplate

@Service
class ReserveUseCase(
    private val cinemaFind: CinemaFindUseCase,
    private val cinemaMerge: CinemaUpdateUseCase,
    private val reserveRepository: ReserveWriteRepository,
    private val transactionTemplate: TransactionTemplate
) {
    fun invoke(request: MovieReserveRequest): Long {
        val cinema = cinemaFind.findBySchedule(request.movieScheduleId)

        val reservation = init(request)
        reserveRepository.save(reservation)

        try {
            val totalAmount = cinema.getTotalTicketPrice(request.count)

            val updatedCinema = cinema.reserve(request.movieScheduleId, request.count)
            val confirm = reservation.confirm(totalAmount)

            transactionTemplate.execute({
                cinemaMerge.invoke(updatedCinema)
                reserveRepository.save(confirm)
            })
        } catch (e: TransactionException) {
            val cancel = reservation.cancel()
            reserveRepository.save(cancel)
        }

        return reservation.id!!
    }
}