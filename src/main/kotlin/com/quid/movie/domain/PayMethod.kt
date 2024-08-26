package movie.domain

import com.quid.movie.domain.Money

interface PayMethod {
    fun pay(amount: Money): Money
}

