package com.quid.spring.multiplex.office.domain

data class Cinema(
    val id: Long,
    val name: String,
    val location: String,
    val theaters: List<Theater>,
    val boxOfficeId: BoxOffice
) {
}