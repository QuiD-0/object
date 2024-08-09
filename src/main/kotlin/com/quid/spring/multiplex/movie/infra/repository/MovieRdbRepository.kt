package com.quid.spring.multiplex.movie.infra.repository

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieRepository
import com.quid.spring.multiplex.movie.infra.repository.entity.toDomain
import com.quid.spring.multiplex.movie.infra.repository.entity.toEntity
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class MovieRdbRepository(
    private val movieJpaRepository: MovieJpaRepository,
) : MovieRepository {

    @Transactional
    override fun save(movie: Movie): Long {
        val entity = movieJpaRepository.save(toEntity(movie))
        return entity.id!!
    }

    @Transactional(readOnly = true)
    override fun findBy(id: Long): Movie {
        return movieJpaRepository.findByIdOrNull(id)
            ?.let { toDomain(it) }
            ?: throw IllegalArgumentException("Movie not found for id: $id")
    }

    @Transactional(readOnly = true)
    override fun findAllBy(director: String): List<Movie> {
        return movieJpaRepository.findAllByDirector(director)
            .map { toDomain(it) }
    }

}