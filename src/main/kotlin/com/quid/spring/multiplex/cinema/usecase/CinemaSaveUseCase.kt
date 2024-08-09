package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CinemaSaveUseCase(
    private val cinema: CinemaFindUseCase,
    private val repository: CinemaWriteRepository,
) {
    val log = LoggerFactory.getLogger(this::class.java)!!

    fun invoke(domain: Cinema): Long {
        log.info("CHECK DUPLICATE CINEMA NAME : ${domain.name}")
        cinema.checkDuplicateName(domain.name)
        log.info("SAVE CINEMA : $domain")
        return repository.save(domain)
    }
}