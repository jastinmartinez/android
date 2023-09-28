import kotlin.random.Random
import  java.util.*
import kotlin.reflect.typeOf

fun main(args: Array<String>) {

//  Constant `Val` can not be mutated
    val a = 1
    println("non mutable value $a")
//   variable var
    var b = 2
    println("mutable value $b")
    b = 3
    println("mutable value $b")

//    Compare for if need to use parenthesis diff of swift LoL

    if (a > b) {
        println("its $a great than $b")
    } else {
        println("its $b great than $a")
    }

//    compare statement using range
    val c = 100
    if (c in 99..1000) {
        println("$c exist in provided range")
    } else {
        println("$c doesn't exist in provided range")
    }

//    when keyword it's an approach to handle cases
    when (c) {
        99 -> println("it's 99")
//        `in` operator to indicate other cases
//        `->` operator to indicate action when case match
        in 99..100 -> print("belongs to range")
        else -> print("non case match")
    }

//    collection creation
// lisfOf can not be change
    val pets = listOf("dog", "cats", "pigs")
    println("not mutable list $pets")
//    multable list
    val mutableListOfPets = mutableListOf("dog", "cat", "pig")
    mutableListOfPets.add("bird")
    mutableListOfPets.removeAt(0)
    println("mutable list $mutableListOfPets")

//    array not mutable and fix sized
    val petsArray = arrayOf("dog", "cat", "pig")

//    loops

    for (pet in petsArray) {
        println(pet)
    }
//    reverse range
    for (n in 5 downTo 1) println("downTo $n")
//    step range
    for (n in 3..6 step 2) println("step of $n")
//    reapat
    var r = 1
    repeat(2) {
        println("repeat $r")
        r += 1
    }

//    using functions
    val day = randomDayOfWeek()
    val food = randomFood(day)
    println("on $day I eat $food")
//    Closures
    println("operation of ${operateAValue(3, ::incrementPlusOne)}")
    val inlineOperation:(Int) -> Int = { value -> value * 2 }
    println("operation of ${operateAValue(3, inlineOperation)}")
    println("operation of ${operateAValue(3, {value -> value * 3 })}")

//    using classes
//    using constructor
    val food1 = Food(numberOfFish = 1)
//    using default constructor
    val food2 = Food(meal = "eggs")
//    using factory fuction
    val food3 = Food.lunch("meat")
}

//    using functions
fun randomDayOfWeek() : String {
    val daysOfWeek = arrayOf("Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Satuday",
        "Sunday")
    return daysOfWeek[java.util.Random().nextInt(daysOfWeek.size)]
}
fun randomFood(day: String): String {
    return when(day) {
        "Monday" -> "flakes"
        "Tuesday" -> "meat"
        "Wednesday" -> "rice"
        "Thursday" -> "soup"
        "Friday" -> "potatoes"
        "Satuday" -> "chicken"
        "Sunday" -> "cookies"
        else -> "Nothing"
    }
}

// this is a closure definition () -> Void when you pass a func as an argment
fun operateAValue(value: Int, ops: (Int) -> Int) : Int {
    return ops(value)
}
fun incrementPlusOne(value: Int) = value + 1

// for class declaration we use `Class` keyword

class Aquarium {
    var width: Int = 10
    var height: Int = 40
    var length: Int = 100
//    property getter
var volume: Int
    get() { return width * height * length / 1000 }
    set(value) {
        height = (value) * 1000 / (width * length)
    }
}

// constructor
class Food(val meal: String = "") {
    //    `constructor` keyword use to overload init
    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
    }

//    Kotlin coding style prefer to use factory func before using construct overload
companion object {
    fun lunch(food: String) = Food(meal = food)
}
    fun printParameter() {
        println("type of ${meal}")
    }
}
// by default classes don't allow inheritance you must include `open` keyword at class and prop level if you want to override
open class Lunch(open var food: String = "Bread") { }
class LateLunch(override var food: String) : Lunch(food = food) { }

//struct
data class ExampleForData(val prop: Int) { }

// Interface

interface  ExampleInterface {
    fun setPorp()
}

// abstract class

abstract class ExampleAbstract {
     abstract fun setProp()
}

//enum

enum class Demo(val something: Int) {
    NORTH(1), WEST(2), SOUTH(3), EAST(4)
}
