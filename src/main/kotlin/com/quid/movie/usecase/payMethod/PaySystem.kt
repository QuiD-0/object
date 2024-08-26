package movie.usecase.payMethod

import com.quid.movie.domain.Money

object PaySystem {
    fun pay(cardNumber: String, validThru: String, cvc: String, amount: Money): Money {
        // 실제 결제 시스템과 통신하는 로직
        return Money(0)
    }
}