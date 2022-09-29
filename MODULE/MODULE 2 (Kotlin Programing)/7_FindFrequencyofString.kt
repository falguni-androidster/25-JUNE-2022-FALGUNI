// Kotlin Program to Find the Frequency of Character in a String

fun main(args: Array<String>){
    var str = "This is Awesome Program"
    var ch = 's'
    var freq = 0

    for(i in 0..str.length - 1){
        if(ch == str[i]){
            freq++
        }
    }

    println("Frequency of $ch = $freq")
}