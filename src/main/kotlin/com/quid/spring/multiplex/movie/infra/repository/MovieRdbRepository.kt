package com.quid.spring.multiplex.movie.infra.repository

import com.quid.spring.multiplex.movie.domain.Movie
import com.quid.spring.multiplex.movie.domain.MovieRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class MovieRdbRepository(
    private val mapper: MovieEntityMapper,
    private val movieJpaRepository: MovieJpaRepository,
) : MovieRepository {

    @Transactional
    override fun save(movie: Movie) = movieJpaRepository.save(mapper.toEntity(movie))
        .run { mapper.toDomain(this) }

}