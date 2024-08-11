package com.quid.spring.multiplex.cinema.infra.controller

import com.quid.spring.multiplex.cinema.infra.controller.request.AssignScheduleRequest
import com.quid.spring.multiplex.cinema.infra.controller.request.CinemaRegistRequest
import com.quid.spring.multiplex.cinema.usecase.AssignScheduleUseCase
import com.quid.spring.multiplex.cinema.usecase.CinemaFindUseCase
import com.quid.spring.multiplex.cinema.usecase.CinemaSaveUseCase
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cinema")
class CinemaController(
    private val cinemaSave: CinemaSaveUseCase,
    private val cinemaFind: CinemaFindUseCase,
    private val assignSchedule: AssignScheduleUseCase
) {
    @GetMapping("/{id}")
    fun findCinema(@PathVariable id: Long) = cinemaFind.findCinemaBy(id)

    @PostMapping
    fun regist(@RequestBody request: CinemaRegistRequest) = cinemaSave.invoke(request.toCinema())

    @PostMapping("/schedule")
    fun assignSchedule(@RequestBody request: AssignScheduleRequest) = assignSchedule.invoke(request)

}