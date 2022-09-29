import java.util.Scanner

fun main(args: Array<String>){
    var sc = Scanner(System.`in`)
    var num : Int
    var count_even = 0
    var count_odd = 0

    for (i in 1..5){
        println("Enter Number = ")
        num = sc.nextInt()
        if (num%2 == 0){
            count_even++
        }else{
            count_odd++
        }
    }
    println("Even numbers = $count_even")
    println("Odd numbers = $count_odd")
}