package com.quid.spring.multiplex.office

import java.math.BigDecimal

data class Item(
    val id: Long,
    val name: String,
    val price: BigDecimal
)