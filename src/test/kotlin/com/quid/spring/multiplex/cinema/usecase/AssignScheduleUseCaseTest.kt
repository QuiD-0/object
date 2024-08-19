package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.MovieSchedule
import com.quid.spring.multiplex.cinema.infra.controller.request.AssignScheduleRequest
import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.usecase.MovieFindUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.anyLong
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class AssignScheduleUseCaseTest {

    private val cinemaFind: CinemaFindUseCase = mock()
    private val cinemaMerge: CinemaUpdateUseCase = mock()
    private val movieFind: MovieFindUseCase = mock()
    private val useCase = AssignScheduleUseCase(cinemaFind, cinemaMerge, movieFind)

    @Test
    fun assignSchedule() {
        val movie = mock<Movie>()
        val schedule = mock<MovieSchedule>()
        val request = mock<AssignScheduleRequest>().apply {
            given(toSchedule(movie.duration)).willReturn(schedule)
        }
        val cinema = mock<Cinema>().apply {
            given(assignSchedule(schedule)).willReturn(this)
        }

        given(cinemaFind.findBy(anyLong())).willReturn(cinema)
        given(movieFind.findBy(anyLong())).willReturn(movie)
        given(cinemaMerge.invoke(cinema)).willReturn(1)

        val result = useCase.invoke(request)

        assertEquals(1, result)
    }
}