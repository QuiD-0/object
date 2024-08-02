package com.quid.spring.multiplex.movie.infra.repository

import org.springframework.data.jpa.repository.JpaRepository

interface MovieJpaRepository : JpaRepository<MovieEntity, Long> {
}