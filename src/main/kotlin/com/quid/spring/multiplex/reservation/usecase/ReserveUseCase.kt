package com.quid.spring.multiplex.reservation.usecase

import com.quid.spring.multiplex.reservation.infra.controller.request.MovieReserveRequest
import org.springframework.stereotype.Service

@Service
class ReserveUseCase {
    fun invoke(request: MovieReserveRequest) {
        println("ReserveUseCase invoked")
    }
}