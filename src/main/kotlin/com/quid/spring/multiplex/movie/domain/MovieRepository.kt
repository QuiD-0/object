package com.quid.spring.multiplex.movie.domain

import com.quid.spring.multiplex.movie.infra.repository.entity.MovieEntity

interface MovieRepository {
    fun save(movie: Movie): Movie
    fun findBy(id: Long): Movie?
    fun findAllBy(director: String): List<Movie>
    fun existsBy(movieId: Long): Boolean
}

