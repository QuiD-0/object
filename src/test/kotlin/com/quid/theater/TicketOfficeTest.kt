package theater

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

class TicketOfficeTest {

    @Test
    fun buyTicket() {
        val ticket = Ticket("nema", 100)
        val ticketOffice = TicketOffice(ticket, AtomicLong(100))

        assertEquals(ticket, ticketOffice.buyTicket(100))
    }

    @Test
    fun changeTicket() {
        val ticket = Ticket("name", 100)
        val ticketOffice = TicketOffice(ticket, AtomicLong(100))
        val invitation = Invitation(LocalDateTime.now().plusHours(1))

        assertEquals(ticket, ticketOffice.changeTicket(invitation))
    }

    @Test
    fun notEnoughFee() {
        val ticket = Ticket("name", 100)
        val ticketOffice = TicketOffice(ticket, AtomicLong(100))

        assertThrows(IllegalArgumentException::class.java) {
            ticketOffice.buyTicket(99)
        }
    }

    @Test
    fun notEnoughTicket() {
        val ticket = Ticket("name", 100)
        val ticketOffice = TicketOffice(ticket, AtomicLong(0))

        assertThrows(IllegalArgumentException::class.java) {
            ticketOffice.buyTicket(100)
        }
    }

    @Test
    fun invalidInvitation() {
        val ticket = Ticket("name", 100)
        val ticketOffice = TicketOffice(ticket, AtomicLong(100))
        val invitation = Invitation(LocalDateTime.now().minusHours(1))

        assertThrows(IllegalArgumentException::class.java) {
            ticketOffice.changeTicket(invitation)
        }
    }

    @Test
    fun ticketPrice() {
        val ticket = Ticket("name", 100)
        val ticketOffice = TicketOffice(ticket, AtomicLong(100))

        assertEquals(100, ticketOffice.ticketPrice())
    }
}