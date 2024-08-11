package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CinemaMergeUseCase(
    private val repository: CinemaWriteRepository,
) {
    private val log = LoggerFactory.getLogger(this::class.java)!!

    fun invoke(domain: Cinema): Long {
        log.info("MERGE CINEMA : $domain")
        return repository.save(domain)
    }
}