package com.quid.spring.multiplex.movie.usecase

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieRepository
import org.springframework.stereotype.Service

@Service
class MovieFindUseCase(
    private val movieRepository: MovieRepository
) {
    fun findBy(id: Long): Movie {
        return movieRepository.findBy(id)
            ?: throw IllegalArgumentException("Movie not found for id: $id")
    }

    fun findAllBy(director: String) = movieRepository.findAllBy(director)

    fun checkExists(movieId: Long) {
        takeIf { movieRepository.existsBy(movieId) }
            ?: throw IllegalArgumentException("Movie not found with id: $movieId")
    }
}