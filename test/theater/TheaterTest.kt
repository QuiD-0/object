package theater

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

class TheaterTest {
    @Test
    fun enterWithInvitation() {
        val theater = Theater(TicketOffice(Ticket("name", 100), AtomicLong(100)))
        val invitation = Invitation(LocalDateTime.now().plusHours(1))
        val audience = Audience(Bag(AtomicLong(100), invitation))

        val ticket = theater.enter(audience)
        assertNotNull { ticket }
    }

    @Test
    fun enterWithoutInvitation() {
        val theater = Theater(TicketOffice(Ticket("name", 100), AtomicLong(100)))
        val audience = Audience(Bag(AtomicLong(100)))

        assertDoesNotThrow { theater.enter(audience) }
        assertEquals(0, audience.bag.amount.get())
        assertEquals(99, theater.ticketOffice.remainTicket.get())
    }
}