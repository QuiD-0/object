package com.quid.spring.multiplex.movie.infra.repository.entity

import com.quid.spring.multiplex.movie.domain.Movie

fun toEntity(movie: Movie): MovieEntity = MovieEntity(
    id = movie.id,
    title = movie.title,
    director = movie.director,
    duration = movie.duration,
    genre = movie.genre,
    rating = movie.rating,
    actors = movie.actors,
    plot = movie.plot
)

fun toDomain(movieEntity: MovieEntity): Movie = Movie(
    id = movieEntity.id,
    title = movieEntity.title,
    director = movieEntity.director,
    duration = movieEntity.duration,
    genre = movieEntity.genre,
    rating = movieEntity.rating,
    actors = movieEntity.actors,
    plot = movieEntity.plot
)