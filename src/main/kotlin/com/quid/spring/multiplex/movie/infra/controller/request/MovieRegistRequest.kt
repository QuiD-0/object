package com.quid.spring.multiplex.movie.infra.controller.request

import com.quid.spring.multiplex.movie.domain.Movie

data class MovieRegistRequest(
    val title: String,
    val duration: Long,
    val genre: String,
    val rating: String,
    val director: String,
    val actors: List<String>,
    val plot: String
) {
    fun toMovie(): Movie {
        return Movie(
            id = null,
            title = title,
            duration = duration,
            genre = genre,
            rating = rating,
            director = director,
            actors = actors,
            plot = plot
        )
    }
}