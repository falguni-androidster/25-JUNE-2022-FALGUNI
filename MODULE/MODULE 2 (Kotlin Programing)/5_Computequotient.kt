import java.util.Scanner

// Kotlin Program to Compute Quotient and Remainder

fun main(args: Array<String>){
    var sc = Scanner(System.`in`)
    var divisor : Int
    var dividend : Int
    var quotient = 0
    var remainder = 0

    println("Enter Divisor = ")
    divisor = sc.nextInt()

    println("Enter Dividend = ")
    dividend = sc.nextInt()

    quotient = divisor / dividend
    println("Quotient = $quotient")

    remainder = divisor % dividend
    println("Remainder = $remainder")

}