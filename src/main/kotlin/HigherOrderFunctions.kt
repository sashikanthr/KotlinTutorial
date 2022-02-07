class HigherOrderFunctions

/*
    They return another function or take a function as an argument. It allows us to write highly functional code.
    You can rely more on functions for example event or click listeners instead of relying more on interfaces for a similar functionality.
    Much of the Kotlin library is composed of higher order functions.
 */

//Here the name of the parameter that takes a function as an input is predicate. The function takes a String as an argument and returns Boolean.
fun printFilteredStrings(list: List<String>, predicate: (String) -> Boolean) {

    //For each is a higher order function that takes another function as an input.
    list.forEach{
        if(predicate(it)) {
            println(it)
        }
    }
}

//In case if the return is a nullable type, we can't directly call the lambda. It should be done as below
fun printFilteredStringsWithNullable(list: List<String>, predicate: ((String) -> Boolean)?) {
    list.forEach {
        if (predicate?.invoke(it) == true) { //? safe call for a null type
            println(it)
        }
    }
}

//Defining a function and assigning it to a variable.
val predicate:(String) -> Boolean = {
    it.startsWith("A") || it.startsWith("S")
}

//Function that returns other functions.,
fun functionThatReturnsAnother() : (String) -> Boolean {
    return { it.startsWith("J")}
}

fun testUnit(): Unit {

}

fun main() {
    val list = listOf("Alexa","Siri", "Jarvis")
    //We can make use of the lambda syntax where if the last parameter of the function is a function, you can specify that function definition outside of the body.
    printFilteredStrings(list) { it.startsWith("J") || it.startsWith("A") }
    //Above line can be used instead of writing it as
    printFilteredStrings(list,{ it.startsWith("J") || it.startsWith("A") })

    printFilteredStringsWithNullable(list, null)

    printFilteredStrings(list, predicate)

    printFilteredStrings(list, functionThatReturnsAnother())

    //Using some functions
    list.filter{
        it.startsWith("A")
    }.map{
      it.length
    }.
    forEach{
        println(it)
    }

    list.associateWith { it.length }.forEach{
        println("${it.key} and $it.value")
    }

    val name = list.findLast{
        it.startsWith("A")
    }.orEmpty()

}