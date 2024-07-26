package movie.infra.console

import movie.domain.*
import java.time.Duration
import java.time.LocalDateTime
import java.util.*

fun main() {
    val office = Office()
    val customer = office.customerInit()
    val command = office.greeting()
    when (command) {
        "1" -> println("영화 예매")
        "2" -> println("예매 확인")
        "3" -> println("예매 취소")
        "4" -> return
        else -> println("잘못된 입력입니다.")
    }
}

class Office {

    private val movies = mutableListOf(
        Movie("타이타닉", Duration.ofMinutes(195)),
        Movie("인터스텔라", Duration.ofMinutes(169)),
        Movie("어벤져스", Duration.ofMinutes(181))
    )

    private val screening = mutableListOf(
        Screening(movies[0], 1, Money(10000), Seats(mutableListOf(), 100), LocalDateTime.now()),
        Screening(movies[1], 2, Money(10000), Seats(mutableListOf(), 100), LocalDateTime.now()),
        Screening(movies[2], 3, Money(10000), Seats(mutableListOf(), 100), LocalDateTime.now())
    )

    fun greeting(): String {
        println("Welcome to the movie theater!")
        println("1. 영화 예매")
        println("2. 예매 확인")
        println("3. 예매 취소")
        println("4. 프로그램 종료")
        println("메뉴를 선택해주세요.")
        return readln()
    }

    fun customerInit(): List<Customer> {
        val customers = mutableListOf<Customer>()
        println("고객 정보를 입력해주세요.")
        while (true) {
            print("이름을 입력해주세요: ")
            val name = readln()
            print("금액을 입력해주세요: ")
            val money = Money(readln().toInt())
            customers.add(Customer(name, money))
            print("계속 입력하시겠습니까? (Y/N): ")
            if (readln().uppercase(Locale.getDefault()) == "N") {
                break
            }
        }
        return customers
    }
}
