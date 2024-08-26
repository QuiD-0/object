package com.quid.spring.multiplex.cinema.domain

interface CinemaWriteRepository {
    fun save(cinema: Cinema): Cinema
    fun save(boxOffice: BoxOffice): BoxOffice
    fun deleteById(id: Long)
}