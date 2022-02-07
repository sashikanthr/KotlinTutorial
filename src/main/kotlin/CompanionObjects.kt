class CompanionObjects

//Imagine you want to create a factory that creates Entity objects

class Entity private constructor(val id:String) {

    //Companion object have access to private members and methods

    companion object {
        fun create() = Entity("id")
    }

 }

class EntityFactory private constructor(val id:String) {

    //Companion object can also be renamed.
    companion object Factory {

        fun create() = EntityFactory("id")

        //They can be used to include constants like static constants in Java
        const val factoryId = "Factory id"
    }

}

//Companion Objects are like other classes. They can implement interfaces as well.

interface CompanionInterface {
    fun companion()
}

class EntityFactoryExtension private constructor(id:String) {
    companion object Factory:CompanionInterface {
        override fun companion() {
            println("Inside companion interface implementation")
        }

        fun create() : EntityFactoryExtension {
            companion()
            return EntityFactoryExtension("Entity Factory Extension")
        }

    }
}

//In short companion objects are quite flexible. They can be used to leverage static classes, members from the world of Java

fun main() {
    // var entity  = Entity() //cannot instantiate as it is a private constructor. This is where companion object can be useful
    var entity = Entity.Companion.create() //Here Companion is implicit if you are using it from Kotlin. It can be removed.
    //If we are using a Companion object from Java, you have to reference that Companion object directly. Companion objects are useful for Jave to Kotlin interop.
    var entityFactory = EntityFactory.Factory.create()
    println("Factory id $entityFactory.factoryId")
    var entityFactoryExtension = EntityFactoryExtension.create()

}