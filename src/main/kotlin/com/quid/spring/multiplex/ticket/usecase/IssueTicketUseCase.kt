package com.quid.spring.multiplex.ticket.usecase

import com.quid.spring.multiplex.cinema.usecase.CinemaFindUseCase
import com.quid.spring.multiplex.movie.usecase.MovieFindUseCase
import com.quid.spring.multiplex.reservation.ReserveFindUseCase
import com.quid.spring.multiplex.ticket.domain.IssueTicketValidator
import com.quid.spring.multiplex.ticket.domain.Ticket
import org.springframework.stereotype.Service

@Service
class IssueTicketUseCase(
    private val reserveFind: ReserveFindUseCase,
    private val movieFind: MovieFindUseCase,
    private val cinemaFind: CinemaFindUseCase
) {
    fun invoke(reservationId: Long): Ticket {
        val reservation = reserveFind.findBy(reservationId)
        IssueTicketValidator(reservation).execute()

        val scheduleId = reservation.scheduleId
        val cinema = cinemaFind.findBy(scheduleId)

        val movieSchedule = cinema.findMovieScheduleBy(scheduleId)
        val theater = cinema.findTheaterBy(movieSchedule.theaterId)
        val movie = movieFind.findBy(movieSchedule.movieId)

        return Ticket(
            id = reservation.id!!,
            reservationId = reservation.id,
            theaterName = theater.name,
            movieName = movie.title,
            seat = mockSeat(reservation.count),
            startTime = movieSchedule.startTime,
            endTime = movieSchedule.endTime,
            price = reservation.totalPrice
        )

    }

    private fun mockSeat(count: Int): String {
        return (1..count).joinToString(",") { "A$it" }
    }

}