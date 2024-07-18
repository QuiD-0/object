package theater

import java.util.concurrent.atomic.AtomicLong

data class TicketOffice(
    val ticket: Ticket,
    var remainTicket: AtomicLong
) {
    fun buyTicket(fee: Long): Ticket {
        require(ticket.isEnoughPrice(fee)) { "not enough fee" }
        require(remainTicket.decrementAndGet() >= 0) { "not enough ticket" }
        return ticket
    }

    fun ticketPrice(): Long = ticket.price

    fun changeTicket(invitation: Invitation): Ticket {
        require(invitation.isValid()) { "invitation is not valid" }
        return ticket
    }
}

