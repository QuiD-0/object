package com.quid.spring.multiplex.cinema.domain

interface CinemaWriteRepository {
    fun save(cinema: Cinema): Long
}