package movie

data class Seats(
    val reserved: MutableList<Customer>,
    val seatsCount: Int
) {
    fun reserve(customers: List<Customer>) {
        require(reserved.size + customers.size <= seatsCount) { "예매할 수 있는 좌석이 부족합니다." }
        reserved.addAll(customers)
    }

}