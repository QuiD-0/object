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

fun toEntity(cinema: Cinema): CinemaEntity {
    return CinemaEntity(
        id = cinema.id,
        name = cinema.name,
        location = cinema.location,
        theaters = cinema.theaters.map { toEntity(it) },
        boxOffice = toEntity(cinema.boxOffice)
    )
}

fun toEntity(theater: Theater): TheaterEntity {
    return TheaterEntity(
        id = theater.id,
        name = theater.name,
        location = theater.location,
        capacity = theater.capacity
    )
}

fun toEntity(boxOffice: BoxOffice): BoxOfficeEntity {
    return BoxOfficeEntity(
        id = boxOffice.id,
        ticketPrice = boxOffice.ticketPrice,
        movieSchedule = boxOffice.movieSchedule.map { toEntity(it) }
    )
}

fun toEntity(movieSchedule: MovieSchedule): MovieScheduleEntity {
    return MovieScheduleEntity(
        id = movieSchedule.id,
        movieId = movieSchedule.movieId,
        startTime = movieSchedule.startTime,
        endTime = movieSchedule.endTime
    )
}