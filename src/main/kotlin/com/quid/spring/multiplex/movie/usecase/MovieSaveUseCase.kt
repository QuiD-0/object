package com.quid.spring.multiplex.movie.usecase

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MovieSaveUseCase(
    private val movieRepository: MovieRepository
) {
    val log = LoggerFactory.getLogger(this::class.java)!!

    fun invoke(movie: Movie): Long {
        log.info("SAVE MOVIE : $movie")
        val save = movieRepository.save(movie)

        return save.id!!
    }
}