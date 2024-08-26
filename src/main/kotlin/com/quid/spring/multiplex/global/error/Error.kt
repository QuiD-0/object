package com.quid.spring.multiplex.global.error

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Error(
    val message: String
) {
    val status: String = "ERROR"
    val timeStamp: String
        get() = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
}

fun Error(message: () -> String): Error = Error(message())