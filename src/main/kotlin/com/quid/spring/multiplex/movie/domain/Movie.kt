package com.quid.spring.multiplex.movie.domain

data class Movie(
    val id: Long?,
    val title: String,
    val duration: Long,
    val genre: String,
    val rating: String,
    val director: String,
    val actors: List<String>,
    val plot: String
)