package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.infra.controller.request.AssignScheduleRequest
import com.quid.spring.multiplex.movie.usecase.MovieFindUseCase
import org.springframework.stereotype.Service

@Service
class AssignScheduleUseCase(
    private val cinemaFind: CinemaFindUseCase,
    private val cinemaMerge: CinemaUpdateUseCase,
    private val movieFind: MovieFindUseCase,
) {
    fun invoke(request: AssignScheduleRequest): Long {
        val movie = movieFind.findBy(request.movieId)
        val foundCinema = cinemaFind.findBy(request.cinemaId)
        val schedule = request.toSchedule(movie.duration)

        val cinema = foundCinema.assignSchedule(schedule)
        return cinemaMerge.invoke(cinema)
    }
}