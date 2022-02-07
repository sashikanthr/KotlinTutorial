interface Interfaces

//Like the class the curly braces can be declared for an interface as well. This could be used as a marker interface.
// We can have multiple classes or interfaces defined in the same file.

interface PersonInfoProvider {
    fun printInfo(person:Person)
}

class BasicInfo : PersonInfoProvider { //This syntax is to mention that the class is implementing the PersonProviderInfo interface

    /*
        In Kotlin override keyword is needed. Otherwise it will complain with a compiler error
     */

    override fun printInfo(person: Person) {
        println("${person._firstName}, ${person._lastName}")
    }
}

abstract class AbstractBasicInfo: PersonInfoProvider //Like Java, abstract classes cannot be instantiated.

//In Kotlin, interfaces can actually provide default implementation for a method.

interface PersonInfoProviderWithPropertiesAndMethods {

    //Property intializers are not allowed within interfaces
    val providerInfo : String
    fun printInfo(person:Person) {
        println("Inside the interface implementation method")
    }
}


 class BasicInfoProvider2: PersonInfoProviderWithPropertiesAndMethods {
    override val providerInfo: String
        get() = "Initialized by the implementing class" // Notice the get implementation here and in Classes.kt for get()
}

//Multiple interfaces
interface SessionInfoProvider {
    val sessionInfo: String
}

//The open keyword is used for opening the class for inheritance.
open class PersonInfoProviderImplementingMultipleInterfaces : SessionInfoProvider, PersonInfoProvider {

    //To override a property we need to modify a member using open command
    protected open var session = "PersonInfoProviderImplementingMultipleInterfaces Session"

    override fun printInfo(person: Person) {
        println("Inside PersonInfoProviderImplementingMultipleInterfaces")
    }

    override val sessionInfo: String
        get() = "From PersonInfoProviderImplementingMultipleInterfaces"
}

//Type checks
fun checkType(infoProvider: PersonInfoProvider) {
    if(infoProvider is SessionInfoProvider) {
        println("This is a session info object")
    }
    if(infoProvider !is SessionInfoProvider) {
        println("This is not a session info object")
    }
}

//Typecasting

fun typeCast(infoProvider: PersonInfoProvider) {
    if(infoProvider is SessionInfoProvider) {
        println((infoProvider as SessionInfoProvider).sessionInfo)
    }

    //We don't have to explicitly do a typecast. The compiler will do a smart casting
    if(infoProvider is SessionInfoProvider) {
        //No need of additional casting
        println(infoProvider.sessionInfo)
    }
}

fun main() {
    val provider = BasicInfo()
    provider.printInfo(Person("Captain", "America"))
    checkType(PersonInfoProviderImplementingMultipleInterfaces())
    typeCast(PersonInfoProviderImplementingMultipleInterfaces())
}

