import java.util.Scanner

fun main(args: Array<String>){
    var sc = Scanner(System.`in`)
    var num : Int
    var sum_positivenum = 0
    var sum_negativenum = 0

    for (i in 1..5){
        println("Enter Number = ")
        num = sc.nextInt()
        if (num<0){
            sum_negativenum += num
        }else{
            sum_positivenum += num
        }
    }
    println("Sum of PositiveNumber = $sum_positivenum")
    println("Sum of NegativeNumber = $sum_negativenum")
}