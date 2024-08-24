package com.quid.spring.multiplex.ticket.usecase

import com.quid.spring.multiplex.cinema.usecase.CinemaFindUseCase
import com.quid.spring.multiplex.movie.usecase.MovieFindUseCase
import com.quid.spring.multiplex.reservation.ReserveFindUseCase
import com.quid.spring.multiplex.reservation.usecase.ReserveSaveUseCase
import com.quid.spring.multiplex.ticket.domain.IssueTicketValidator
import com.quid.spring.multiplex.ticket.domain.Ticket
import com.quid.spring.multiplex.ticket.domain.TicketWriteRepository
import com.quid.spring.multiplex.ticket.domain.issueTicket
import org.springframework.stereotype.Service
import org.springframework.transaction.support.TransactionTemplate

@Service
class IssueTicketUseCase(
    private val reserveFind: ReserveFindUseCase,
    private val reserveMerge: ReserveSaveUseCase,
    private val movieFind: MovieFindUseCase,
    private val cinemaFind: CinemaFindUseCase,
    private val ticketWrite: TicketWriteRepository,
    private val transactionTemplate: TransactionTemplate
) {
    fun invoke(reservationId: Long): Ticket {
        val reservation = reserveFind.findBy(reservationId)
        IssueTicketValidator(reservation).execute()

        val scheduleId = reservation.scheduleId
        val cinema = cinemaFind.findBy(scheduleId)

        val movieSchedule = cinema.findMovieScheduleBy(scheduleId)
        val theater = cinema.findTheaterBy(movieSchedule.theaterId)
        val movie = movieFind.findBy(movieSchedule.movieId)

        val ticket = issueTicket(reservation, movieSchedule, movie.title, theater.name)
        val updatedReservation = reservation.issueComplete()

        return transactionTemplate.execute {
            reserveMerge.invoke(updatedReservation)
            ticketWrite.save(ticket)
        }!!
    }
}