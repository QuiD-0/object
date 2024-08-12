package com.quid.spring.multiplex.movie.domain

interface MovieRepository {
    fun save(movie: Movie): Movie
    fun findBy(id: Long): Movie?
    fun findAllBy(director: String): List<Movie>
    fun existsBy(movieId: Long): Boolean
}

