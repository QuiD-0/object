package com.quid.spring.multiplex.cinema.usecase

import com.quid.spring.multiplex.cinema.domain.Cinema
import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock

class CinemaFindUseCaseTest{

    private val repository: CinemaReadRepository = mock()
    private val useCase = CinemaFindUseCase(repository)

    @Test
    fun findCinemaBy(){
        val cinema = mock<Cinema>()
        repository.apply {
            given(findBy(1)).willReturn(cinema)
        }

        val result = useCase.findCinemaBy(1)

        assertEquals(cinema, result)
    }

    @Test
    fun checkDuplicateName(){
        repository.apply {
            given(existsBy("Cinema")).willReturn(true)
        }

        assertThrows<IllegalArgumentException> { useCase.checkDuplicateName("Cinema") }
    }

}