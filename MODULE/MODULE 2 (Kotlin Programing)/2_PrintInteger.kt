import java.util.Scanner

//Kotlin Program to Print an Integer (Entered by the User)

fun main(args: Array<String>){
    var sc = Scanner(System.`in`)
    var num1 : Int
    var num2 : Int

    println("Enter Number1 = ")
    num1 = sc.nextInt()

    println("Enter number 2 = ")
    num2 = sc.nextInt()

    println("Number1 = $num1 & Number2 = $num2" )
}