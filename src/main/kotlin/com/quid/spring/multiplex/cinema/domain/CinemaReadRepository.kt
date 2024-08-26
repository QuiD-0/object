package com.quid.spring.multiplex.cinema.domain

interface CinemaReadRepository {
    fun findById(id: Long): Cinema
    fun existsByName(name: String): Boolean
    fun findBySchedule(movieScheduleId: Long): Cinema
    fun findByTheaterId(theaterId: Long): Cinema
    fun findMovieScheduleBy(scheduleId: Long): MovieSchedule
    fun findTheaterBy(theaterId: Long): Theater
    fun findBoxOfficeBySchedule(movieScheduleId: Long): BoxOffice
}