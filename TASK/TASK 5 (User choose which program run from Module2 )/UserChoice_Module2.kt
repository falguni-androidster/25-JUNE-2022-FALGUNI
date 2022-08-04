import java.util.*

// WAP of all modules in one frame and Choice of user what user choose module?
// If user choose anyone than this module related run program.
// With using of class and function.

var sc = Scanner(System.`in`)

class User(){

    // Option 1 - Print "Hello World!!!"
    fun printhello(){
        println("Hello World!!!")
    }

    // Option 2 - To Print an Integer (Entered by the User)
    fun printinteger(num1 : Int, num2 : Int){
        println("Number1 = $num1 & Number2 = $num2" )
    }

    // Option 3 - To Add Two Integers
    fun addtwointegernum(num1 : Int, num2: Int){
        println("Sum of Number1 & Number2 = ${num1+num2}")
    }

    // Option 4 - To Multiply two Floating Point Numbers
    fun multiplytwofloatnum(num1 : Float, num2: Float){
        println("Multiple Two Floating Numbers = ${num1*num2}")
    }

    // To Find ASCII value of a character
    fun findasciivalueofchar(ch : Char){
        println("ASCII value of $ch character = ${ch.toInt()}")
    }

    // To Compute Quotient and Remainder
    fun computequotient(divisor : Int, dividend : Int){
        println("Quotient = ${divisor / dividend}")
        println("Remainder = ${divisor % dividend}")
    }

    // To Check Whether a Number is Even or Odd
    fun findevenoddnum(num : Int){
        if (num % 2 == 0){
            println("Number $num is Even")
        }else{
            println("Number $num is Odd")
        }
    }

    // To Find the Frequency of Character in a String
    fun findfreqofstring(ch : Char){
        var str = "This is Awesome Program"
        var freq = 0
        for(i in 0..str.length - 1){
            if(ch == str[i]){
                freq++
            }
        }
        println("String = $str")
        println("Frequency of $ch in String = $freq")
    }

    // To find max value using function as express
    fun findmaxvalue(list: List<Int>) : Int? {
        println("Maximum value = ${findmax(list)}")
        return list.maxOrNull()
    }

    // Write simple function name start() return the string “OK” (basic function)
    fun start(): String {
        var ok = "OK"
        return ok
    }
}

fun main(args : Array<String>){

    var user = """----------------------------------------------------------------------------------
                          User Choices
----------------------------------------------------------------------------------
                 Choose 1 - Print Hello world!!!
                 Choose 2 - Print Integer Number(Entered by you)
                 Choose 3 - To Add Two Integers
                 Choose 4 - To Multiply two Floating Point Numbers
                 Choose 5 - To Find ASCII value of a character
                 Choose 6 - To Compute Quotient and Remainder
                 Choose 7 - To Check Whether a Number is Even or Odd
                 Choose 8 - To Find the Frequency of Character in a String
                 Choose 9 - To find max value using function as express
                 Choose 10 - Write simple function name start() return the string 'OK'
-------------------------------------------------------------------------------------------
    """
    println(user)

    var user_choice : Int
    println("Enter Your Choice : ")
    user_choice = sc.nextInt()

    var int_num1 : Int
    var int_num2 : Int

    var float_num1 : Float
    var float_num2 : Float

    var ch : Char

    if (user_choice == 1){

        User().printhello()

    }else if (user_choice == 2){

        println("Enter number1 = ")
        int_num1 = sc.nextInt()
        println("Enter number2 = ")
        int_num2 = sc.nextInt()
        User().printinteger(int_num1, int_num2)

    }else if(user_choice == 3){

        println("Enter number1 = ")
        int_num1 = sc.nextInt()
        println("Enter number2 = ")
        int_num2 = sc.nextInt()
        User().addtwointegernum(int_num1, int_num2)

    }else if (user_choice == 4){

        println("Enter Float Number1 = ")
        float_num1 = sc.nextFloat()
        println("Enter Float Number2 = ")
        float_num2 = sc.nextFloat()
        User().multiplytwofloatnum(float_num1, float_num2)

    }else if (user_choice == 5){

        println("Enter Character = ")
        ch = sc.next().single()
        User().findasciivalueofchar(ch)

    }else if (user_choice == 6){

        println("Enter Divisor = ")
        int_num1 = sc.nextInt()
        println("Enter Dividend = ")
        int_num2 = sc.nextInt()
        User().computequotient(int_num1, int_num2)

    }else if (user_choice == 7){

        println("Enter number = ")
        int_num1 = sc.nextInt()
        User().findevenoddnum(int_num1)

    }else if (user_choice == 8){

        ch = 's'
        User().findfreqofstring(ch)

    }else if (user_choice == 9){

        var list = listOf(10, 4, 1, 15, 20, 8)
        println(list)
        User().findmaxvalue(list)

    }else if (user_choice == 10){

        println(User().start())

    }else{

        println("Invalid Input")

    }

}


