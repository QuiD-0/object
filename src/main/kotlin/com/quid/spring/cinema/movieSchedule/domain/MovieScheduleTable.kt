package com.quid.spring.cinema.movieSchedule.domain

data class MovieScheduleTable(
    val id: Long,
    val theaterId: Long,
    val list: MutableList<MovieSchedule>,
) {

}
