package com.quid.spring.multiplex.office.usecase

import com.quid.spring.multiplex.office.domain.BoxOfficeRepository
import org.springframework.stereotype.Service

@Service
class BoxOfficeFind(
    private val boxOfficeRepository: BoxOfficeRepository
) {
    fun findBy(id: Long) = boxOfficeRepository.findBy(id)
}