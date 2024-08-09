package com.quid.spring.multiplex.movie.domain

interface MovieRepository {
    fun save(movie: Movie): Long
    fun findBy(id: Long): Movie
    fun findAllBy(director: String): List<Movie>
}

