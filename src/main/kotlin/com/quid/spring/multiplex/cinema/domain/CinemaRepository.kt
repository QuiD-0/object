package com.quid.spring.multiplex.cinema.domain

interface CinemaRepository {
    fun findBy(id: Long): Cinema
}