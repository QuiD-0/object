package movie.domain

interface PayMethod {
    fun pay(amount: Money): Money
}

