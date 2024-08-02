package com.quid.spring.multiplex.movie.usecase

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieSaveUseCase(
    private val movieRepository: MovieRepository
) {
    fun save(movie: Movie) = movieRepository.save(movie)
}