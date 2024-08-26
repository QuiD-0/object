package com.quid.spring.multiplex.global.error

import org.springframework.http.HttpStatus

interface HttpStatusSelector {
    operator fun invoke(ex:Exception): HttpStatus

    class HttpStatusSelectorImpl : HttpStatusSelector {
        override fun invoke(ex: Exception): HttpStatus =
            when (ex) {
                is IllegalArgumentException -> HttpStatus.BAD_REQUEST
                is NoSuchElementException -> HttpStatus.NOT_FOUND
                is IllegalStateException -> HttpStatus.CONFLICT
                is UnauthorizedException -> HttpStatus.UNAUTHORIZED
                else -> HttpStatus.INTERNAL_SERVER_ERROR
            }
    }

    companion object : HttpStatusSelector by HttpStatusSelectorImpl()
}

class UnauthorizedException(message: String) : RuntimeException(message)