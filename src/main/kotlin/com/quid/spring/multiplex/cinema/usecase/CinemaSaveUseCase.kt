package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CinemaSaveUseCase(
    private val cinemaFind: CinemaFindUseCase,
    private val repository: CinemaWriteRepository,
) {
    val log = LoggerFactory.getLogger(this::class.java)!!

    fun invoke(cinema: Cinema): Long {
        log.info("CHECK DUPLICATE CINEMA NAME : ${cinema.name}")
        cinemaFind.checkDuplicateName(cinema.name)
        log.info("SAVE CINEMA : $cinema")
        return repository.save(cinema).id!!
    }
}