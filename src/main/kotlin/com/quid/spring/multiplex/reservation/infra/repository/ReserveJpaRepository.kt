package com.quid.spring.multiplex.reservation.infra.repository

import com.quid.spring.multiplex.reservation.infra.repository.entity.ReservationEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ReserveJpaRepository : JpaRepository<ReservationEntity, Long>