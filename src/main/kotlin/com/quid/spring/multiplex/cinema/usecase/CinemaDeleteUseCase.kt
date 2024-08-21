package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import org.springframework.stereotype.Service

@Service
class CinemaDeleteUseCase(
    private val cinemaRepository: CinemaWriteRepository
) {
    fun invoke(id: Long) {
        cinemaRepository.deleteById(id)
    }
}