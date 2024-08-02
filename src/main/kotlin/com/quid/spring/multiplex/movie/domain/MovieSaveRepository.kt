package com.quid.spring.multiplex.movie.domain

interface MovieSaveRepository {

    fun save(movie: Movie): Movie
}

