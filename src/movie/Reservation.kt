package movie

data class Reservation(
    val screening: Screening,
    val seats: Seats,
) {
    fun invoke(money: Money, customers: List<Customer>): ReservationResponse {
        seats.reserve(customers)
        return ReservationResponse(
            List(customers.size) { Ticket(screening) },
            money - screening.calculateTotalAmount(customers.size)
        )
    }
}

