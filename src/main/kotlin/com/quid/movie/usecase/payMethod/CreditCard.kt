package movie.usecase.payMethod

import com.quid.movie.domain.Money
import movie.domain.PayMethod

data class CreditCard(
    val cardNumber: String,
    val validThru: String,
    val cvc: String
) : PayMethod {
    override fun pay(amount: Money): Money = PaySystem.pay(cardNumber, validThru, cvc, amount)
}