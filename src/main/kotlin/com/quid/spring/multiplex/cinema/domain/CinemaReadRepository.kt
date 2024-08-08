package com.quid.spring.multiplex.cinema.domain

interface CinemaReadRepository {
    fun findBy(id: Long): Cinema
    fun existsBy(name: String): Boolean
}