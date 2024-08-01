package com.quid.spring.multiplex.order.domain

import java.math.BigDecimal

data class OrderItem (
    val id: Long,
    val itemId: Long,
    val quantity: Int,
    val price: BigDecimal
){
}