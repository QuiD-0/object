package movie

data class ReservationResponse(
    val tickets: List<Ticket>,
    val remainMoney: Money
)