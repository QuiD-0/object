package theater

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

class InvitationTest{
    @Test
    fun isInvitationValid(){
        val invitation = Invitation(LocalDateTime.now().plusHours(1))
        assertTrue(invitation.isValid())
    }

    @Test
    fun isInvitationInvalid(){
        val invitation = Invitation(LocalDateTime.now().minusHours(1))
        assertFalse(invitation.isValid())
    }
}