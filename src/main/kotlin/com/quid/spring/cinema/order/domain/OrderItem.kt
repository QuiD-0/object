package com.quid.spring.cinema.order.domain

import java.math.BigDecimal

data class OrderItem (
    val id: Long,
    val movieScheduleId: Long,
    val quantity: Int,
    val price: BigDecimal
){
}