package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import com.quid.spring.multiplex.cinema.infra.controller.request.CinemaRegistRequest
import org.springframework.stereotype.Service

@Service
class CinemaPersistUseCase(
    private val cinema: CinemaFindUseCase,
    private val repository: CinemaWriteRepository,
) {

    fun invoke(request: CinemaRegistRequest): Long {
        val domain = request.toDomain()

        cinema.checkDuplicateName(domain.name)
        return repository.save(domain)
    }

}