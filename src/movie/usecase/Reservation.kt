package movie.usecase

import movie.domain.DiscountPolicy
import movie.domain.NoneDiscountPolicy
import movie.domain.*

data class Reservation(
    val screening: Screening,
    val seats: Seats,
) {
    fun invoke(
        money: Money,
        customers: List<Customer>,
        discountPolicy: DiscountPolicy = NoneDiscountPolicy
    ): ReservationResponse {
        seats.reserve(customers)
        return ReservationResponse(
            List(customers.size) { Ticket(screening) },
            money - FeeCalculator(screening.getTotalAmount(customers.size), discountPolicy).calculate()
        )
    }
}

data class ReservationResponse(
    val tickets: List<Ticket>,
    val remainMoney: Money
)