package com.quid.spring.multiplex.cinema.infra.repository

import com.quid.spring.multiplex.cinema.domain.CinemaReadRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.dao.InvalidDataAccessApiUsageException

@Disabled
@SpringBootTest
class CinemaReadRdbRepositoryTest(
    @Autowired
    private val cinemaReadRepository: CinemaReadRepository
) {

    @Test
    @DisplayName("ID로 영화관을 조회한다.")
    fun findById() {
        val cinema = cinemaReadRepository.findById(1)
        assertNotNull(cinema)
    }

    @Test
    @DisplayName("존재하지 않는 경우")
    fun `existsBy should return false when cinema not exists`() {
        val exists = cinemaReadRepository.existsByName("cinema100")
        assertFalse(exists)
    }

    @Test
    @DisplayName("영화 스케줄 ID로 영화관을 조회한다.")
    fun `findBySchedule should return cinema when cinema exists`() {
        val cinema = cinemaReadRepository.findBySchedule(1)
        assertNotNull(cinema)
    }

    @Test
    @DisplayName("존재하지 않는 영화 스케줄 ID로 조회할 경우 예외가 발생한다.")
    fun `findBySchedule should throw exception when cinema not exists`() {
        assertThrows(InvalidDataAccessApiUsageException::class.java) {
            cinemaReadRepository.findBySchedule(100)
        }
    }

}