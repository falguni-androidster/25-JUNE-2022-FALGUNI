import java.util.*

//Kotlin Program to Check Whether a Number is Even or Odd

fun main(args: Array<String>){
    var sc = Scanner(System.`in`)
    var num : Int

    println("Enter number = ")
    num = sc.nextInt()

    if (num % 2 == 0){
        println("Number $num is Even")
    }else{
        println("Number $num is Odd")
    }
}