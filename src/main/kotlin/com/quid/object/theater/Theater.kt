package theater


data class Theater(
    val ticketOffice: TicketOffice,
) {
    fun enter(audience: Audience): Ticket =
        if (audience.hasInvitation()) {
            ticketOffice.changeTicket(audience.bag.invitation!!)
        } else {
            val price = ticketOffice.ticketPrice()
            ticketOffice.buyTicket(audience.pay(price))
        }
}