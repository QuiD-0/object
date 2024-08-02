package com.quid.spring.multiplex.movie.infra.repository

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieSaveRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class MovieRdbSaveRepository(
    private val mapper: MovieEntityMapper,
    private val movieJpaRepository: MovieJpaRepository,
) : MovieSaveRepository {

    @Transactional
    override fun save(movie: Movie) = movieJpaRepository.save(mapper.toEntity(movie))
        .run { mapper.toDomain(this) }

}