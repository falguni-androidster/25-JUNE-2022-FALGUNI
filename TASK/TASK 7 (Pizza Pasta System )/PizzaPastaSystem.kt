import java.util.Scanner

// Customer Order pizza and pasta with offers

var sc = Scanner(System.`in`)

var choice = true

var pizza_amount = 0f
var pasta_amount = 0f
var total_amount = 0f

var count_softdrink = 0
var count_bruschetta = 0
var count_chocobrownie = 0

var pizza_order = 0
var pasta_order = 0


class PizzaPastaSystem(){

    // Customer Order Pizza and Count pizza amount & offer
    fun Orderpizza(small_pizza: Int, medium_pizza: Int, large_pizza: Int) {
        pizza_amount = 0f
        for (i in 1..small_pizza) {
            pizza_amount += 10.99f
        }

        for (i in 1..medium_pizza){
            pizza_amount += 20.99f
        }

        for (i in 1..large_pizza){
            pizza_amount += 29.99f
        }

        println("Your pizza order amount is : $pizza_amount AUD ")

        // 4 or more pizza order offer
        if (pizza_order >= 4){
            count_softdrink ++
            println("           *** Congratulation!! 1.5lt soft drink free ***             ")
        }
    }

    // Customer Order Pasta and Count pasta amount & offer
    fun Orderpasta(small_pasta: Int, medium_pasta: Int, large_pasta: Int) {
        pasta_amount = 0f
        for (i in 1..small_pasta) {
            pasta_amount += 9.5f
        }

        for (i in 1..medium_pasta){
            pasta_amount += 17.00f
        }

        for (i in 1..large_pasta){
            pasta_amount += 27.50f
        }

        println("Your pasta order amount is : $pasta_amount AUD")

        // 4 or more pasta order offer
        if (pasta_order >= 4){
            count_bruschetta++
            println("          *** Congratulation!! get 2 bruschetta ***            ")
        }
    }

    // Bill Details
    fun pizzapastabill( total_order: Int, pizza_amount: Float, pasta_amount: Float, total_amount: Float ) {
        println(" Payment received from Pizza : $pizza_amount")
        println(" Payment received form pasta : $pasta_amount")
        println(" Payment received Today : $total_amount")
        println(" Number of pizza and pasta sold in one shift :  $total_order")
        println(" Number of 1.5lt soft drink bottles given : $count_softdrink")
        println(" Number of bruschetta given to customer : $count_bruschetta")
        println(" Number of choco brownie ice-cream given to customer : $count_chocobrownie")
    }

}

fun getsumintarraylist(items : List<Int>) : Int{
    var sum = 0
    for (i in items){
        sum += i
    }
    return sum
}

fun getsumfloatarraylist(items : List<Float>) : Float{
    var sum = 0f
    for (i in items){
        sum += i
    }
    return sum
}

fun main(args : Array<String>){

    var welcome = """-------------------------------------------------------------------
                  Welcome to Amazing Pizza and Pasta Pizzeria
                      Press 1 : Order Menu
                      Press 2 : Exit
------------------------------------------------------------------
    """
    println(welcome)

    var customer_choice : Int
    var customer_name : String
    var another_customer : String

    var small_pizza : Int
    var medium_pizza : Int
    var large_pizza : Int

    var small_pasta : Int
    var medium_pasta : Int
    var large_pasta : Int

    var total_orderarr = ArrayList<Int>()

    var pizza_amountarr = ArrayList<Float>()
    var pasta_amountarr = ArrayList<Float>()
    var total_amountarr = ArrayList<Float>()

    try {
        println("Enter Your Choice = ")
        customer_choice = sc.nextInt()

        if (customer_choice == 1){

            var details = """--------------------------------------------------------------------------------
    1. Small Pizza = 10.99 AUD
    2. Medium Pizza = 20.99 AUD
    3. Large Pizza = 29.99 AUD
            
      *** Buy 4 or more pizza and get 1.51lt of soft drink free ***
            
    1. Small Pasta = 9.5 AUD
    2. Medium Pasta = 17.00 AUD
    3. Large Pasta = 27.50 AUD
             
      *** Buy 4 or more pasta and get 2 bruschetta free ***
            
      *** Buy 4 or more Pizza & Pasta and get 2 choco brownies ice-cream ***  
        
----------------------------------------------------------------------------------------"""
            println(details)

            while (choice){

                println("Enter Customer Name = ")
                customer_name = sc.next()

                println("------------------------------Customer Order Details-------------------------------------")
                println("Welcome, $customer_name")

                println("------------------------------ Order Pizza Menu----------------------------- ")

                println("Enter number of Small Pizza : ")
                small_pizza = sc.nextInt()
                println("Enter number of Medium Pizza : ")
                medium_pizza = sc.nextInt()
                println("Enter number of Large Pizza : ")
                large_pizza = sc.nextInt()

                pizza_order = small_pizza + medium_pizza + large_pizza
                println("Numbers of Pizza Order You want = $pizza_order")
                PizzaPastaSystem().Orderpizza(small_pizza, medium_pizza, large_pizza)

                println("------------------------------ Order Pasta Menu------------------------------ ")
                println("Enter number of Small Pasta : ")
                small_pasta = sc.nextInt()
                println("Enter number of Medium Pasta : ")
                medium_pasta = sc.nextInt()
                println("Enter number of Large Pasta : ")
                large_pasta = sc.nextInt()

                println("------------------------------------------------------------------------")

                pasta_order = small_pasta + medium_pasta + large_pasta
                println("Numbers of Pasta Order You want = $pasta_order")
                PizzaPastaSystem().Orderpasta(small_pasta, medium_pasta, large_pasta)

                println("------------------------------------------------------------------------")
                // 4 or more pizza and pasta offer
                if (pizza_order+pasta_order >= 4){
                    count_chocobrownie++
                    println("          *** Congratulation!! get 2 choco brownies ice-cream free ***          ")
                }

                // Total Amount of pizza and pasta
                total_amount = pizza_amount + pasta_amount
                println("Your total order is : $total_amount AUD ")

                println("------------- Your net order amount of the day is : $total_amount AUD -------------")

                total_orderarr.add(pizza_order + pasta_order)
                pizza_amountarr.add(pizza_amount)
                pasta_amountarr.add(pasta_amount)
                total_amountarr.add(total_amount)

                // Another customer
                println("Want to Enter order from another customer(Y/N)) = ")
                another_customer = sc.next()

                choice = another_customer == "y"
            }

            // Pizza & Pasta bill
            println("------------------------------- Pizza and Pasta Bill------------------------------------")
            PizzaPastaSystem().pizzapastabill(getsumintarraylist(total_orderarr), getsumfloatarraylist(pizza_amountarr),
                getsumfloatarraylist(pasta_amountarr), getsumfloatarraylist(total_amountarr))

            println("Bye Bye !!!!!")

        } else{
            choice = false
        }

    }catch (e : Exception){
        println("Invalid Input")
    }
}