package com.quid.spring.multiplex.movie.infra.controller

import com.quid.spring.multiplex.movie.infra.controller.request.MovieRegistRequest
import com.quid.spring.multiplex.movie.usecase.MovieFindUseCase
import com.quid.spring.multiplex.movie.usecase.MovieSaveUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/movie")
class MovieController(
    private val movieFind: MovieFindUseCase,
    private val movieSave: MovieSaveUseCase
) {

    @GetMapping("/{id}")
    fun findMovie(@PathVariable id: Long) = movieFind.findBy(id)

    @PostMapping
    fun saveMovie(@RequestBody request: MovieRegistRequest): Long = movieSave.invoke(request.toMovie())
}