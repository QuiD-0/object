package com.quid.spring.cinema.ticketOffice.domain

data class Cinema(
    val id: Long,
    val name: String,
    val location: String,
    val theaters: List<Theater>
) {
}