// WAP to find max value using function as express

fun main(args: Array<String>){

    var list = listOf(10, 4, 1, 15, 20, 8)

    println("Maximum value = ${findmax(list)}")

}

fun findmax(list: List<Int>) : Int? {
    return list.maxOrNull()
}
