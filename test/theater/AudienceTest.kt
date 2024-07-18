package theater

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.util.concurrent.atomic.AtomicLong

class AudienceTest{

    @Test
    fun hasInvitation(){
        val invitation = Invitation(LocalDateTime.now().plusHours(1))
        val audience = Audience(Bag(AtomicLong(100), invitation))

        assertTrue(audience.hasInvitation())
    }

    @Test
    fun hasNotInvitation(){
        val audience = Audience(Bag(AtomicLong(100)))

        assertFalse(audience.hasInvitation())
    }

    @Test
    fun pay() {
        val audience = Audience(Bag(AtomicLong(100)))

        assertEquals(100, audience.bag.pay(100))
        assertEquals(0, audience.bag.amount.get())
    }

}