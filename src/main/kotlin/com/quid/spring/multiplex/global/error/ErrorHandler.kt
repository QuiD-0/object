package com.quid.spring.multiplex.global.error

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ErrorHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(ex: Exception): ResponseEntity<Error> =
        ResponseEntity<Error>(
            Error { ex.message ?: "Unknown Error" },
            HttpStatusSelector(ex)
        ).also { ex.printStackTrace() }
}