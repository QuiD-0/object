package com.quid.spring.multiplex.movie.usecase

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieSaveRepository
import org.springframework.stereotype.Service

@Service
class MovieSaveUseCase(
    private val movieRepository: MovieSaveRepository
) {
    fun save(movie: Movie) = movieRepository.save(movie)
}