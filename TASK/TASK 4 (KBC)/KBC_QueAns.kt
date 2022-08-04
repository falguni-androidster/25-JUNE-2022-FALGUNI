import java.util.Scanner

// KBC question answer

var point : Int = 0
var sc = Scanner(System.`in`)

fun main(args: Array<String>){

    var kbc = """                       .....................................................................      
                                                      KBC
                        Ask question for user with given four option and user choose answer
                        If user choose answer is right than give +50 points else give -20 points.
                        .........................................................................
    """
    println(kbc)

    que1()
    que2()
    que3()
    que4()
    que5()
    que6()
    que7()
    que8()
    que9()
    que10()
    println("-----------------------------------------")
    println("Your Total Score : $point")
}

fun addpoint() {
    point += 50
    println("You win +50 points")
    println("Your Score = $point")
}

fun minuspoint() {
    point -= 20
    println("You loose -20 points")
    println("Your score = $point")
}

fun choice(ch : String) {
    var choice : String
    println("Answer = ")
    choice = sc.next()

    if (choice == ch){
        addpoint()
    }else{
        minuspoint()
    }
}

// Question 1
fun que1() {
    var que = """1. One rabbit saw 6 elephants while going towards River. 
        Every elephant saw 2 monkeys are going towards river. 
        Every monkey holds one tortoise in their hands.

How many animals are going towards the river?

A) 14
B) 11
C) 8
D) 5
"""

    println(que)
    choice("d")
}

// Question 2
fun que2(){
    var que = """2. If a giraffe has two eyes, a monkey has two eyes, 
        and an elephant has two eyes, how many eyes do we have?

A) 3
B) 4
C) 1
D) 2
"""

    println(que)
    choice("b")
}

// Question 3
fun que3(){
    var que = """3. A man was murdered in his office.
The suspects are Ericson, Maggi, Joel, Benny, Sona, Patick.
A calendar found near the man has blood written 6, 4, 9, 10, 11.

Who is the killer?

A) Maggi
B) Ericson
C) Sona
D) Joel
"""

    println(que)
    choice("d")
}

// Question 4
fun que4(){
    var que = """4. They come out at night without being called and are lost in the day without being stolen. 
        What are they?

A) Light
B) Bats
C) Stars
D) Flights
"""

    println(que)
    choice("c")
}

// Question 5
fun que5(){
    var que = """5. Poor people have it.
        Rich people need it.
        If you eat it you die.
        What is it?
        
A) Money
B) Brain
C) Luxury items
D) Nothing
"""

    println(que)
    choice("d")
}

// Question 6
fun que6(){
    var que = """6. A man has 12 sons.And each of his sons has 1 sister.
        How many children the man has?

A) 24
B) 25
C) 13
D) 12
"""

    println(que)
    choice("c")
}

// Question 7
fun que7(){
    var que = """7. What Does My Name Mean, If my Mother is a Mathematician, and my Father is a Chemist. 
        And they gave a Code to My Name as "Iron59".

Crack my Name?

A) Felix
B) Alex
C) Elix
D) Selix
"""

    println(que)
    choice("a")
}

// Question 8
fun que8(){
    var que = """8. A couple went to movie. They have 6 daughters and each daughter have 4 brothers
        and each brother have 2 babies.
       
In total how many people went to movie?

A) 40
B) 20
C) 2
D) 36
"""

    println(que)
    choice("c")
}

// Question 9
fun que9(){
    var que = """9. A party consists of grandmother, father, mother, four sons & their wives and one son
        & two daughters to each son.
     
How many females are there in all?

A) 24
B) 14
C) 11
D) 18
"""

    println(que)
    choice("b")
}

// Question 10
fun que10(){
    var que = """10. At the baseball game, Henry was sitting in seat 253.
         Marla was sitting to the right of Henry in seat 254. In the seat to the left of Henry was George. 
         Inez was sitting to the left of George. 
         
Which seat is Inez sitting in?

A) 251
B) 254
C) 255
D) 256
"""

    println(que)
    choice("a")
}