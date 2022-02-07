class Inheritance

//By default, classes in Kotlin are final. They cannot be inherited.
class FancyInfoProvider: PersonInfoProviderImplementingMultipleInterfaces() {

   override fun printInfo(person: Person) {
        super.printInfo(person)
        println("Inside FancyInfoProvider printInfo")
    }

    override val sessionInfo: String
        get() = super.sessionInfo

    //To override a property we need to modify a member using open command
    override var session: String = "" //This is for initialization. Variable needs to be initialized
        get() = "FancyInfoProvider session"
        set(value) {field = value}

}

fun main() {
    val provider = FancyInfoProvider()
    //provider.session // session (property) can be accessed directly. This is an implementation detail. If we don't want to expose this we can add the protected modifier.
}