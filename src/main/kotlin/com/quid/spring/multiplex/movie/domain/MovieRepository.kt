package com.quid.spring.multiplex.movie.domain

interface MovieRepository {

    fun save(movie: Movie): Movie
}

