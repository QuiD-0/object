package com.quid.spring.multiplex.movie.infra.repository

import com.quid.spring.multiplex.movie.domain.Movie
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "MOVIE")
class MovieEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    val id: Long?,
    @Column(name = "TITLE")
    val title: String,
    @Column(name = "DURATION")
    val duration: Int,
    @Column(name = "GENRE")
    val genre: String,
    @Column(name = "RATING")
    val rating: String,
    @Column(name = "DIRECTOR")
    val director: String,
    @ElementCollection(targetClass = String::class)
    @CollectionTable(name = "ACTORS", joinColumns = [JoinColumn(name = "MOVIE_ID")])
    val actors: List<String>,
    @Column(name = "PLOT")
    val plot: String
) {
}

fun toEntity(movie: Movie): MovieEntity = MovieEntity(
    id = movie.id,
    title = movie.title,
    director = movie.director,
    duration = movie.duration,
    genre = movie.genre,
    rating = movie.rating,
    actors = movie.actors,
    plot = movie.plot
)

fun toDomain(movieEntity: MovieEntity): Movie = Movie(
    id = movieEntity.id,
    title = movieEntity.title,
    director = movieEntity.director,
    duration = movieEntity.duration,
    genre = movieEntity.genre,
    rating = movieEntity.rating,
    actors = movieEntity.actors,
    plot = movieEntity.plot
)