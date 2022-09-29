import java.util.Scanner

fun main(args:Array<String>) {

    var sc = Scanner(System.`in`)
    var fname: String
    var lname: String
    var age: Int
    var gender: String
    var product_name: String
    var product_qty: Int = 60
    var todayprice: Int = 4783
    var makingcharges: Int = 8
    var amount: Int
    var purchase_amount: Int
    var discount : Int = 20
    var gst : Int = 10
    var disamount : Int = 26800
    var netamount : Int

    var kj = """                     KALYAN JEWELLERS                   
                           ------------------------------------------
                           ------------------------------------------
    """
    println("$kj")

    println("First name : ")
    fname = sc.next()

    println("Last name : ")
    lname = sc.next()

    println("Age : ")
    age = sc.nextInt()

    println("Gender : ")
    gender = sc.next()

    println("Product name : ")
    product_name = sc.next()

    println("Product quantity : $product_qty gm")
    println("Today's Price : $todayprice (1gm = 22karat)" )
    println("Making charges : $makingcharges %")

    amount = product_qty * todayprice
    println("Amount : $amount")

    purchase_amount = amount + ((makingcharges * product_qty)/100)
    println("Purchase amount : $purchase_amount")

    if (age > 0 && age < 65) {
            if (gender == "Male"){
                if (purchase_amount >= 100000 && purchase_amount < 200000){
                    discount = 5
                }else if (purchase_amount >= 200000 && purchase_amount < 300000){
                    discount = 15
                }else if (purchase_amount >= 300000){
                    discount = 25
                }else{
                    discount = 0
                }
            } else {
                if (purchase_amount >= 100000 && purchase_amount < 200000) {
                    discount = 15
                } else if (purchase_amount >= 200000 && purchase_amount < 300000) {
                    discount = 25
                } else if (purchase_amount >= 300000) {
                    discount = 35
                } else {
                    discount = 0
                }
            }
    } else{
        if (gender == "Male") {
            if (purchase_amount >= 100000 && purchase_amount < 200000) {
                discount = 10
            } else if (purchase_amount >= 200000 && purchase_amount < 300000) {
                discount = 20
            } else if (purchase_amount >= 300000) {
                discount = 30
            } else {
                discount = 0
            }
        }else{
            if (purchase_amount >= 100000 && purchase_amount < 200000){
                discount = 20
            }else if (purchase_amount >= 200000 && purchase_amount < 300000){
                discount = 30
            }else if (purchase_amount >= 300000){
                discount = 40
            }else{
                discount = 0
            }
        }

    }

    println("Discount : $discount %")
    println("GST : $gst %")
    println("Dis-amount : $disamount")
    println("-----------------------------------------")

    netamount = purchase_amount + ((purchase_amount*gst)/100) + disamount - discount
    println("Net Amount : $netamount")

}