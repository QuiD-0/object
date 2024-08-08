package com.quid.spring.multiplex.cinema.infra.repository.entity

import com.quid.spring.multiplex.cinema.domain.BoxOffice
import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.MovieSchedule
import com.quid.spring.multiplex.cinema.domain.Theater


fun toBoxOffice(boxOfficeEntity: BoxOfficeEntity): BoxOffice = BoxOffice(
    id = boxOfficeEntity.id,
    ticketPrice = boxOfficeEntity.ticketPrice,
    movieSchedule = boxOfficeEntity.movieSchedule.map { toMovieSchedule(it) }
)

fun toCinema(cinemaEntity: CinemaEntity): Cinema = Cinema(
    id = cinemaEntity.id,
    name = cinemaEntity.name,
    location = cinemaEntity.location,
    theaters = cinemaEntity.theaters.map { toTheater(it) },
    boxOffice = toBoxOffice(cinemaEntity.boxOffice)
)


fun toMovieSchedule(movieScheduleEntity: MovieScheduleEntity): MovieSchedule = MovieSchedule(
    id = movieScheduleEntity.id,
    movieId = movieScheduleEntity.movieId,
    startTime = movieScheduleEntity.startTime,
    endTime = movieScheduleEntity.endTime
)


fun toTheater(theaterEntity: TheaterEntity): Theater = Theater(
    id = theaterEntity.id,
    name = theaterEntity.name,
    location = theaterEntity.location,
    capacity = theaterEntity.capacity
)