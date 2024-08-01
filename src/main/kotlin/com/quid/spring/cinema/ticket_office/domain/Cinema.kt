package com.quid.spring.cinema.ticket_office.domain

data class Cinema(
    val id: Long,
    val name: String,
    val location: String,
    val theaters: List<Theater>
) {
}