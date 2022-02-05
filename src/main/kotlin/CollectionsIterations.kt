/*
    Basic array - can be defined using a convenience function
 */

fun arrayOfStrings(): Array<String> {
    val interests = arrayOf("Badminton","Tennis") // Type inference
    println(interests.size)
    println(interests[1]) //index
    println(interests.get(1)) //using get
    return interests
}

fun main() {
    arrayOfStrings();
    println("For loop like Java")
    loopInterests()
    println("For loop like Kotlin")
    loopInterestsKotlin()
    println("Loop with Index")
    loopInterestWithIndex()
    println("Lists")
    definingList()
    println("Maps")
    defineMaps()
    println("Mutables")
    mutableListsAndMaps()
    println("Paremters with collection")
    greetPersons(listOf("Jarvis","Friday","Spock"),"Welcome!")
    println("Vargargs")
    greetPersonsWithFlexibility("Welcome!", "Jarvis", "Friday", "Alexa")
    println("Spread Operator *")
    greetPersonsWithSpreadOperator("Welcome",*arrayOf("Welcome", "Jarvis", "Alexa"))
    println("Named arguments")
    greetWithNamedArguments(person="Jarvis", greeting="Welcome!")
    println("Default Value")
    greetWithDefaultValue();
}

/*
    Iteration using a for loop more like Java
 */

fun loopInterests() {
    var interetsts  = arrayOfStrings();
    for(interest in interetsts) {
        println(interest)
    }
}

/*
    More Kotlin like
    'it' is the default for each element in the array. It might not be readable always. You can always pass a lambda as well

    Why we are using curly braces instead of parantheses? - It is lambda syntax within Kotlin. Idea is if we have a function and its only parameter is another function, then you can omit the parentheses and pass the function with the open and close braces.
    This will be discussed in Higher Order Functions later.



 */
fun loopInterestsKotlin() {
    //using it
    arrayOfStrings().forEach { println(it) }
    //using lambda
    arrayOfStrings().forEach { interest -> println(interest) }
}

/*
    To also include the index data
 */
fun loopInterestWithIndex() {
    arrayOfStrings().forEachIndexed{index, interest -> println("$interest at $index")}
}

/*
    Everything that is applicable to Arrays is applicable to lists as well. There will be more methods available with lists
    We use the convenience function listOf
 */

fun definingList() {
    var newInterests = listOf("Fencing", "Boxing", "Swimming")
    newInterests.forEach{
        println(it)
    }
}

/*
    Maps - Key value pair. using convenience function mapOf
 */
fun defineMaps() {
    var numberMap = mapOf(1 to "a", 10 to "b", 100 to "c")
    numberMap.forEach{key,value -> println("Mapping for $key is $value")}

}

/*
    There is mutable and immutable collection types. By default, collection types in Kotlin are immutable. You can add or remove.
    If you need a mutable list, we need to use the convenience function mutableListOf or mutableMapOf
 */

fun mutableListsAndMaps() {
    var newInterests = mutableListOf("Fencing", "Boxing", "Swimming")
    newInterests.add("BodyJam")
    newInterests.forEach{
        println(it)
    }

    var numberMap = mutableMapOf(1 to "a", 10 to "b", 100 to "c")
    numberMap.put(1000,"d")
    numberMap.forEach{key,value -> println("Mapping for $key is $value")}
}

/*
    Greet multiple persons with a collection type as a parameter
 */
fun greetPersons(persons:List<String>, greeting:String) {
    persons.forEach{ person -> println("Hey $person, $greeting") }
}

/*
    Functions in Kotlin provides another feature which provides some flexibility. vararg is treated as an array.
    This will not work when we are sending an array of strings.
 */
fun greetPersonsWithFlexibility(greeting:String,vararg persons:String) {
    persons.forEach{ person -> println("Hey $person, $greeting") }
}

/*
    To send an array of strings as an argument in the above function, we use a spread operator *
 */

fun greetPersonsWithSpreadOperator(greeting:String,vararg persons:String) {
    persons.forEach{ person -> println("Hey $person, $greeting") }
}

/*
    Another important feature of Kotlin is named arguments. They allow us to specify which parameter an argument can be used for what parameter.
    The limitation is that the named argument syntax is applicable for all parameters.
 */

fun greetWithNamedArguments(greeting:String, person:String) {
    println("Hey $person, $greeting")
}

/*
    We can also specify a default value for a parameter. This becomes a powerful feature for builder pattern (Needs more investigation)
 */

fun greetWithDefaultValue(greeting: String = "Hello", person:String = "Nate") = println("Hey $greeting, $person")