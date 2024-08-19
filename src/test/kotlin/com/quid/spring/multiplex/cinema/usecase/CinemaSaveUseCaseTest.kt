package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
import com.quid.spring.multiplex.cinema.domain.CinemaWriteRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.BDDMockito.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class CinemaSaveUseCaseTest {

    private val mock = mock(CinemaReadRepository::class.java)
    private val find = CinemaFindUseCase(mock)
    private val repository = mock<CinemaWriteRepository>()
    private val useCase = CinemaSaveUseCase(find, repository)

    @Test
    fun saveCinema() {
        val cinema = mock<Cinema>()

        given(cinema.name).willReturn("cinema")
        given(repository.save(cinema)).willReturn(1)

        val result = useCase.invoke(cinema)

        assertEquals(1, result)
    }

    @Test
    fun saveCinemaWithException() {
        val cinema = mock<Cinema>()

        given(cinema.name).willReturn("cinema")
        given(mock.existsByName(anyString())).willReturn(true)

        assertThrows<IllegalArgumentException> { useCase.invoke(cinema) }
    }
}