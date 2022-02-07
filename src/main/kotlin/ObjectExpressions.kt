class ObjectExpressions

fun main() {

    //An object expression can be used to define an anonymous inner class.
    val provider = object: PersonInfoProvider,SessionInfoProvider {
        override fun printInfo(person: Person) {
            println("An object expression from an anonymous class")
        }

        override val sessionInfo: String
            get() = "SessionInfo from object expression"

    }

    println("${provider.sessionInfo} and ${provider.printInfo(Person("Silver", "Tower"))}")

    /*
        Output
        An object expression from an anonymous class
        SessionInfo from object expression and kotlin.Unit
     */
}