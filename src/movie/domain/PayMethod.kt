package movie.domain

interface PayMethod {
    fun pay(amount: Money): Money
}

data class Cash(
    val payAmount: Money
) : PayMethod {
    override fun pay(amount: Money): Money = payAmount - amount
}

data class CreditCard(
    val cardNumber: String,
    val validThru: String,
    val cvc: String
) : PayMethod {
    override fun pay(amount: Money): Money = PaySystem.pay(cardNumber, validThru, cvc, amount)
}

object PaySystem {
    fun pay(cardNumber: String, validThru: String, cvc: String, amount: Money): Money {
        // 실제 결제 시스템과 통신하는 로직
        return Money(0)
    }
}