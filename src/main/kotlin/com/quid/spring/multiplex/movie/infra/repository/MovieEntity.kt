package com.quid.spring.multiplex.movie.infra.repository

import jakarta.persistence.*

@Entity
@Table(name = "MOVIE")
class MovieEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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