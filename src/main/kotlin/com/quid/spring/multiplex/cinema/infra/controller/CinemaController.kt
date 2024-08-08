package com.quid.spring.multiplex.cinema.infra.controller

import com.quid.spring.multiplex.cinema.infra.controller.request.CinemaRegistRequest
import com.quid.spring.multiplex.cinema.usecase.CinemaFindUseCase
import com.quid.spring.multiplex.cinema.usecase.CinemaPersistUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cinema")
class CinemaController(
    private val cinemaPersist: CinemaPersistUseCase,
    private val cinemaFind: CinemaFindUseCase
) {
    @GetMapping("/{id}")
    fun findCinema(@PathVariable id: Long) = cinemaFind.findCinemaBy(id)

    @PostMapping
    fun regist(request: CinemaRegistRequest) = cinemaPersist.invoke(request)
}