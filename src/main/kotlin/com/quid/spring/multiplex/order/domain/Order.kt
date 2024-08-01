package com.quid.spring.multiplex.order.domain

data class Order(
    val id: Long,
    val userId: Long,
    val orderItem: List<OrderItem>,
    val couponId: Long?,
    val status: OrderStatus,
    val createdAt: Long,
    val updatedAt: Long
) {
}

