//Variables

/*
    2 Types
    Mutable variables declared by var keyword
    Local immutable variables declared by val keyword
 */

/*/
    Variables can be defined outside of the function and they are defined as top level variables.
    Syntax -
    Diff between Java and Kotlin is types are non-null by default. Value and Nullable value are different.
    Ex: -  Cannot assign var name: String = null
    It should be val nullable:String? = null

    Kotlin supports type inferences on types and properties

    This means we don't have to specify a type.

    Ex: - var greeting = "Hello" is recognized as a string

    This doesn't apply to nullable String

    Control Flow Statements like if..else..elseif work like Java.

    Additional condition statement is when statement which is analogous to switch statement

    Else can be used as a combination of when

 */

val greeting: String? = "Hello"
var nullable:String? = null
var withoutType = "I am without type"

fun main() {
   val name: String = "Test"
    //name = "Test 2" - Gives error Val cannot be reassigned
    println(name)
    println(greeting)
    println(nullable)
    nullable = "Test"
    println(nullable)
    println(withoutType)

    //Control flow
    if(nullable!=null) {
        println("Not null")
    }

    when(greeting) {
        null -> println("Greeting is null")
        else -> {
            println("Inside else")
        }
    }

    //Using when for assigning a value

        val greetingForPrint = when(greeting) {
            null -> "Hi"
            else -> "Hola"
        }

    println("Greeting for Print - "+greetingForPrint)
}





