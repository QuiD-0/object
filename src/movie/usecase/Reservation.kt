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
        val totalPrice = discountPolicy.discountAmount(screening.getTotalAmount(customers.size))

        return ReservationResponse(
            List(customers.size) { Ticket(screening) },
            payMoney.pay(totalPrice)
        )
    }
}

data class ReservationResponse(
    val tickets: List<Ticket>,
    val remainMoney: Money
)