package com.quid.spring.multiplex.cinema.domain

import java.math.BigDecimal

data class BoxOffice(
    val id: Long?,
    val ticketPrice: BigDecimal,
    val movieSchedule: List<MovieSchedule> = emptyList(),
)