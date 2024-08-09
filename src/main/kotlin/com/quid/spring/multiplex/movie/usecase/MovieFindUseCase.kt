package com.quid.spring.multiplex.movie.usecase

import com.quid.spring.multiplex.movie.domain.MovieRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MovieFindUseCase(
    private val movieRepository: MovieRepository
) {
    val log = LoggerFactory.getLogger(this::class.java)!!

    fun findBy(id: Long) = movieRepository.findBy(id)

    fun findAllBy(director: String) = movieRepository.findAllBy(director)
}