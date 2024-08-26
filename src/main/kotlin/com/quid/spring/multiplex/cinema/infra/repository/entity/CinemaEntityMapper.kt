package com.quid.spring.multiplex.cinema.infra.repository.entity

import com.quid.spring.multiplex.cinema.domain.BoxOffice
import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.MovieSchedule
import com.quid.spring.multiplex.cinema.domain.Theater
import com.quid.spring.multiplex.global.vo.Money


fun toBoxOffice(entity: BoxOfficeEntity): BoxOffice = BoxOffice(
    id = entity.id,
    ticketPrice = Money(entity.ticketPrice, entity.currency),
    movieSchedule = entity.movieSchedule.map { toMovieSchedule(it) }
)

fun toCinema(entity: CinemaEntity): Cinema = Cinema(
    id = entity.id,
    name = entity.name,
    location = entity.location,
    theaters = entity.theaters.map { toTheater(it) },
    boxOffice = toBoxOffice(entity.boxOffice)
)


fun toMovieSchedule(entity: MovieScheduleEntity): MovieSchedule = MovieSchedule(
    id = entity.id,
    movieId = entity.movieId,
    theaterId = entity.theaterId,
    capacity = entity.capacity,
    startTime = entity.startTime,
    endTime = entity.endTime
)


fun toTheater(entity: TheaterEntity): Theater = Theater(
    id = entity.id,
    name = entity.name,
    location = entity.location,
    capacity = entity.capacity
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
        ticketPrice = boxOffice.ticketPrice.amount,
        currency = boxOffice.ticketPrice.currency,
        movieSchedule = boxOffice.movieSchedule.map { toEntity(it) }
    )
}

fun toEntity(movieSchedule: MovieSchedule): MovieScheduleEntity {
    return MovieScheduleEntity(
        id = movieSchedule.id,
        movieId = movieSchedule.movieId,
        theaterId = movieSchedule.theaterId,
        capacity = movieSchedule.capacity,
        startTime = movieSchedule.startTime,
        endTime = movieSchedule.endTime
    )
}