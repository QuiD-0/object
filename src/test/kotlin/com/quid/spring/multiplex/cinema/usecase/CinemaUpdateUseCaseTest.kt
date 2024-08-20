package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class CinemaUpdateUseCaseTest {

    private val repository = mock<CinemaWriteRepository>()
    private val useCase = CinemaUpdateUseCase(repository)

    @Test
    fun updateCinema() {
        val cinema = mock<Cinema>()
        repository.apply {
            given(save(cinema)).willReturn(cinema)
        }

        val result = useCase.invoke(cinema)

        assertEquals(0, result)
    }

    @Test
    fun updateCinemaWithException() {
        val cinema = mock<Cinema>().apply {
            given(checkRegistered()).willThrow(IllegalArgumentException::class.java)
        }

        assertThrows<IllegalArgumentException> { useCase.invoke(cinema) }
    }
}