package com.quid.spring.multiplex.cinema.domain

interface CinemaPersistRepository {
    fun save(cinema: Cinema): Long
}