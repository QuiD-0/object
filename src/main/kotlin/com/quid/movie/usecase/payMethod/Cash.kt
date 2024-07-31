package movie.usecase.payMethod

import movie.domain.Money
import movie.domain.PayMethod

data class Cash(
    val payAmount: Money
) : PayMethod {
    override fun pay(amount: Money): Money = payAmount - amount
}