package com.quid.spring.multiplex.office.infra.repository

import com.quid.spring.multiplex.office.domain.BoxOffice
import com.quid.spring.multiplex.office.domain.BoxOfficeRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class BoxOfficeRdbRepository: BoxOfficeRepository {

    @Transactional(readOnly = true)
    override fun findBy(id: Long): BoxOffice {
        //todo
        return null as BoxOffice
    }
}