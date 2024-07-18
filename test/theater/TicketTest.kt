package theater

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class TicketTest{

    @Test
    fun isEnough(){
        val ticket = Ticket("name", 100)
        assertTrue(ticket.isEnoughPrice(100))
    }

    @Test
    fun isNotEnough(){
        val ticket = Ticket("name", 100)
        assertFalse(ticket.isEnoughPrice(99))
    }
}