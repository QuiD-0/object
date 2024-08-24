package com.quid.spring.multiplex.reservation.infra.controller

import com.quid.spring.multiplex.reservation.infra.controller.request.MovieReserveRequest
import com.quid.spring.multiplex.reservation.usecase.ReserveMovieUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/reserve")
class ReserveController(
    private val reserve: ReserveMovieUseCase
) {

    @PostMapping
    fun reserveMovie(@RequestBody request: MovieReserveRequest) = reserve.invoke(request)
}