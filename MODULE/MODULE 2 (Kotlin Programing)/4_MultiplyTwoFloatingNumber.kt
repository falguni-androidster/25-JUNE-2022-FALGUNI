import java.util.Scanner

// Kotlin Program to Multiply two Floating Point Numbers and Program to Find ASCII value of a character

fun main(args: Array<String>){
    var sc = Scanner(System.`in`)
    var num1 : Float
    var num2 : Float
    var multi_num = 0f

    var multi = """                            MULTIPLY TWO FLOATING NUMBERS
                            ............................."""
    println(multi)
    println("Enter Float number1 = ")
    num1 = sc.nextFloat()

    println("Enter Float number2 = ")
    num2 = sc.nextFloat()

    multi_num = num1 * num2
    println("Multiple Two Floating Numbers = $multi_num")

    var ascii_char = """                            ...............................
                            FIND ASCII VALUE OF A CHARACTER
                            ..............................."""
    println(ascii_char)

    var char : Char
    println("Enter Character : ")
    char = sc.next().single()

    var ascii = char.toInt()
    println("ASCII value of $char character = $ascii")
}