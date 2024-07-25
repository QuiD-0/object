package movie.usecase

import movie.domain.*

data class Reservation(
    val screening: Screening,
    val payMoney: PayMethod,
    val customers: List<Customer>,
    val discountPolicy: DiscountPolicy
) {
    fun invoke(): ReservationResponse {
        screening.reserve(customers)
        val totalAmount = screening.getTotalAmount(customers.size)
        val finalPrice = discountPolicy.discountAmount(totalAmount)

        return ReservationResponse(
            List(customers.size) { Ticket(screening) },
            payMoney.pay(finalPrice)
        )
    }
}

data class ReservationResponse(
    val tickets: List<Ticket>,
    val remainMoney: Money
)