package com.quid.spring.multiplex.ticket.domain

import com.quid.spring.multiplex.reservation.domain.OrderStatus
import com.quid.spring.multiplex.reservation.domain.Reservation

data class IssueTicketValidator(
    val reservation: Reservation,
) {
    fun execute() {
        require(reservation.status == OrderStatus.CONFIRMED) { "예약 상태가 확인되지 않았습니다." }
        require(reservation.ticketIssued.not()) { "이미 티켓이 발급된 예약입니다." }
    }
}