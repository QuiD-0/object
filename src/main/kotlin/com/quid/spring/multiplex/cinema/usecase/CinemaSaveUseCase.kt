package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import org.springframework.stereotype.Service

@Service
class CinemaSaveUseCase(
    private val cinema: CinemaFindUseCase,
    private val repository: CinemaWriteRepository,
) {

    fun invoke(domain: Cinema): Long {
        cinema.checkDuplicateName(domain.name)
        return repository.save(domain)
    }

}