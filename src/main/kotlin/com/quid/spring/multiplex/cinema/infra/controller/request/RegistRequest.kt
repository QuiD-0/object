package com.quid.spring.multiplex.cinema.infra.controller.request

import com.quid.spring.multiplex.cinema.domain.BoxOffice
import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.Theater
import java.math.BigDecimal

data class CinemaRegistRequest(
    val cinemaName: String,
    val location: String,
    val theaters: List<TheaterRegistRequest>,
    val boxOffice: BoxOfficeRegistRequest
) {
    fun toDomain(): Cinema {
        return Cinema(
            id = null,
            name = cinemaName,
            location = location,
            theaters = theaters.map { it.toDomain() },
            boxOffice = boxOffice.toDomain()
        )
    }
}

data class TheaterRegistRequest(
    val name: String,
    val location: String,
    val capacity: Int
) {
    fun toDomain(): Theater {
        return Theater(
            id = null,
            name = name,
            location = location,
            capacity = capacity
        )
    }
}

data class BoxOfficeRegistRequest(
    val ticketPrice: BigDecimal,
) {
    fun toDomain(): BoxOffice {
        return BoxOffice(
            id = null,
            ticketPrice = ticketPrice
        )
    }
}
