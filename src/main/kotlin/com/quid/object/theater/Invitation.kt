package theater

import java.time.LocalDateTime

data class Invitation(
    val dateTime: LocalDateTime
) {
    fun isValid(): Boolean = LocalDateTime.now().isBefore(dateTime)
}