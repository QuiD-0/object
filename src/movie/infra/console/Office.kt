package movie.infra.console

import movie.domain.Money
import movie.domain.Movie
import movie.domain.Screening
import movie.domain.Seats
import java.time.Duration
import java.time.LocalDateTime

fun main() {
    val command = Office().greeting()
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
}
