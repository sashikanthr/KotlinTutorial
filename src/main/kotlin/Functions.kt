
/*
    fun funname(args) :Return
*/

fun fun_Name(/*No parameters yet*/) :String /*Here String is the return type, Giving String? will allow null values*/ {
    return "New fun name"
}

/*
    Here main is not having a return type. When we dont have anything to return, by default it returns Unit. So, you can either use it or omit the type value.
*/

fun main() {
    println("Invoking the new function")
    fun_Name();
    fun_without_return()
    println(fun_name_single_expr_function())
    fun_with_parameters("Test Parameter")
    println(fun_with_single_line("Test Parameter 2"))
    println(greetPerson("Jarvis", "Get ready!"))
}

fun fun_without_return() :Unit {
    println("I am function with Unit return type")
}


/*
    Functions also support type inference. Below function infers a String type
 */
fun fun_name_single_expr_function() = "I am a single expression function"

/*
    To define a function parameters
    Syntax: fun funname(parameter_name:parameterType)
 */

fun fun_with_parameters(parameter1:String) {
    val message = "Here is the parameter you passed - "+parameter1
    println(message)
    /*
        Interesting Feature: Kotlin supports string templates which supports variable / parameter values to a predefined stirng template

     */
    val new_message = "Hello, I am using a string template $parameter1"
    println(new_message)
}

/*
    Single line function of the above function
 */

fun fun_with_single_line(parameter1:String) = "Hey, I am a single paramter function using a string template $parameter1"

/*
    Multiple parameters
 */
fun greetPerson(personName:String, greeting:String) = "Hey $personName, $greeting"
