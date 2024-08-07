package com.quid.spring.multiplex.movie.usecase

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MovieSave(
    private val movieRepository: MovieRepository
) {
    val log = LoggerFactory.getLogger(this::class.java)!!

    fun save(movie: Movie): Movie {
        log.info("SAVE MOVIE : $movie")
        return movieRepository.save(movie)
    }
}