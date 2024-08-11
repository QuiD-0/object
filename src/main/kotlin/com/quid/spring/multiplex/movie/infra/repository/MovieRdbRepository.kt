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
    override fun save(movie: Movie): Movie {
        return movieJpaRepository.save(toEntity(movie))
            .run { toDomain(this) }
    }

    @Transactional(readOnly = true)
    override fun findBy(id: Long): Movie? {
        return movieJpaRepository.findByIdOrNull(id)
            ?.let { toDomain(it) }
    }

    @Transactional(readOnly = true)
    override fun findAllBy(director: String): List<Movie> {
        return movieJpaRepository.findAllByDirector(director)
            .map { toDomain(it) }
    }

    @Transactional(readOnly = true)
    override fun existsBy(movieId: Long): Boolean {
        return movieJpaRepository.existsById(movieId)
    }

}