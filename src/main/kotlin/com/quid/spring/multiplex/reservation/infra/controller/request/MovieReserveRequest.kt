package com.quid.spring.multiplex.reservation.infra.controller.request

data class MovieReserveRequest(
    val userId: Long,
    val movieScheduleId: Long,
    val amount: Long,
    val couponId: Long?
) {
}