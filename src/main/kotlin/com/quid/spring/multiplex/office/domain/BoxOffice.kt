package com.quid.spring.multiplex.office.domain

import java.math.BigDecimal

data class BoxOffice(
    val id: Long,
    val ticketPrice: BigDecimal,
    val movieSchedule: List<MovieSchedule>,
    val items: List<Item>
)