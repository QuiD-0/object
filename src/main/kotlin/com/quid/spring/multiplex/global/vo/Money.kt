package com.quid.spring.multiplex.global.vo

import com.quid.spring.multiplex.global.vo.Currency.KRW
import java.math.BigDecimal

data class Money(
    val amount: BigDecimal,
    val currency: Currency = KRW
) {
    constructor(amount: Int, currency: Currency = KRW) : this(BigDecimal(amount), currency)

    operator fun times(times: Int) = Money(amount * BigDecimal(times), currency)

    override fun toString(): String {
        return "$amount ${currency.displayName}"
    }
}