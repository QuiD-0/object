package com.quid.spring.multiplex.office.domain

interface BoxOfficeRepository {
    fun findBy(id: Long): BoxOffice
}