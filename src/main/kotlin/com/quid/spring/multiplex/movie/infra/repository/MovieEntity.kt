package com.quid.spring.multiplex.movie.infra.repository

import jakarta.persistence.ElementCollection
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class MovieEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val title: String,
    val duration: Int,
    val genre: String,
    val rating: String,
    val director: String,
    @ElementCollection(targetClass = String::class)
    val actors: List<String>,
    val plot: String
) {
}