import java.util.Scanner

// Bank Management System

var totalamount : Int = 10000
var sc = Scanner(System.`in`)

class Bankmanagement{

    // create account
    fun account(acc_name : String, acc_number: Int){
        println("Account Name = $acc_name")
        println("Account Number = $acc_number")
        println("Opening Balance : $totalamount")
    }

    // withdraw amount
    fun withdrawamount(){
        var withdraw_amount : Int
        println("Enter Withdraw Amount : ")
        withdraw_amount = sc.nextInt()
        if(withdraw_amount >= 0){
            totalamount -= withdraw_amount
            println("Your amount = $totalamount")
        }else{
            println("Invalid Input Withdraw Amount")
        }
    }

    // Deposit amount
    fun depositamount(){
        var deposit_amount : Int
        println("Enter Deposit Amount : ")
        deposit_amount = sc.nextInt()

        if (deposit_amount >= 0){
            totalamount += deposit_amount
            println("Your Amount = $totalamount")
        }else{
            println("Invalid Input Deposit Amount")
        }
    }
}



fun main (args : Array<String>){

    try {
        var acc_name : String
        var acc_number : Int

        var management = """----------------------------------------------------------------
                        BANK MANAGEMENT SYSTEM
                            (1) CREATE ACCOUNT
                            (2) WITHDRAW AMOUNT
                            (3) DEPOSIT AMOUNT
----------------------------------------------------------------
    
    """
        println(management)

        println("Enter Account Name : ")
        acc_name = sc.next()
        println("Enter Account Number : ")
        acc_number = sc.nextInt()

        println("------------------------------------------------------------------")
        Bankmanagement().account(acc_name,acc_number)

        var user_choice : String
        var status = true

        while (status) {
            println("You want to Withdraw Amount press 'w' OR Deposit Amount press 'd'  : ")
            user_choice = sc.next()
            if (user_choice == "w") {
                status = true
                Bankmanagement().withdrawamount()
                println("Do you want to continue press 'y' for YES & press 'n' for NO : ")
                user_choice = sc.next()
                if (user_choice == "y") {
                    status == true
                } else {
                    status == false
                }
            } else if (user_choice == "d") {
                status = true
                Bankmanagement().depositamount()
                println("Do you want to continue press 'y' for YES & press 'n' for NO : ")
                user_choice = sc.next()
                if (user_choice == "y") {
                    status == true
                } else {
                    status == false
                }
            } else {
                println("Invalid Input")
                status = false
            }
        }
    }catch (e : Exception){
        println("Invalid Input")
    }
}