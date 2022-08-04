import java.util.Scanner

// Kotlin Program to Add Two Integers

fun main (args: Array<String>){
    var sc = Scanner(System.`in`)
    var num1 : Int
    var num2 : Int
    var sum = 0

    println("Enter Number1 = ")
    num1 = sc.nextInt()
    println("Enter Number2 = ")
    num2 = sc.nextInt()
    sum = num1 + num2
    println("Sum of Number1 & NUmber2 = $sum")

}