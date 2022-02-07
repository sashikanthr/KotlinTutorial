import EntityType.*
import java.util.*

class SealedClass

/*
    Sealed class allows us to define restricted class hierarchy.
 */

//An instance of sealed classes cannot be created directly
sealed class SealedEntity() {

    //Data classes are Kotlin's way of providing very concise immutable data types. They are also convenient where equals(). toString(), and hashcode() are automatically generated for you.
    data class Easy(val id:String, val name:String): SealedEntity()
    data class Medium(val id:String, val name:String): SealedEntity()
    //We can additional property for a SealedClass. This is one of the key differentiator between Enum classes and Enum classes.

    data class Hard(val id:String, val name:String, val multiplier: Float): SealedEntity()

    //We can also use different type of classes. For example we can remove the data keyword
    class Hell(val id:String, val name:String, val multiplier: Float): SealedEntity()

    //We can also define Object declarations in Sealed classes
    object Help {
        val name = "Help"
    }

    object HelpSealedEntity: SealedEntity() {
        val name = "Sealed Help"
    }

}

object SealedEntityFactory {

    fun create(type:EntityType) : SealedEntity {
        val id  = UUID.randomUUID().toString()
        val name = when(type) {
            EASY -> type.getFormattedName()
            MEDIUM -> type.getFormattedName()
            HARD -> type.getFormattedName()
            HELP -> type.getFormattedName()
        }
        return when(type) {
            EASY -> SealedEntity.Easy(id,name)
            MEDIUM -> SealedEntity.Medium(id,name)
            HARD -> SealedEntity.Hard(id,name,2f)
            //HELP -> SealedEntity.Help // Compiler will shout because Help is not extending SealedEntity
            HELP -> SealedEntity.HelpSealedEntity
        }
    }
}

fun main() {
    val entity:SealedEntity = SealedEntityFactory.create(EASY)
    //To demonstrate more advantages of Sealed Classes
    val msg = when(entity) { //Compiler enforces static type checking you to handle all child classes of Sealed Class Entity.
        is SealedEntity.Easy -> "Easy class"
        is SealedEntity.Hard -> "Hard class"
        is SealedEntity.Hell -> "Hell class"
        SealedEntity.HelpSealedEntity -> "Help class" //As this is an object declaration and a singleton, the class can be referenced directly
        is SealedEntity.Medium -> "Medium Class"
    }

    println(msg)

    val easyEntity1 = SealedEntityFactory.create(EASY)
    val easyEntity2 = SealedEntityFactory.create(EASY)

    val entity3 = SealedEntity.Easy("1234", "name")
    val entity4 = SealedEntity.Easy("1234", "name")

    //Example to demonstrate data classes compare all the properties in terms of date for equality.
    if(easyEntity1 == easyEntity2) {
        println("Entity classes are equal")
    } else {
        println("Entity classes are not equal")
    }

    if(entity3 == entity4) {
        println("Entity classes are equal")
    } else {
        println("Entity classes are not equal")
    }

    //Another interesting feature is copy constructor. You can specify the property you like to change.
    val entity5 = SealedEntity.Easy("1234", "name")
    entity5.copy(name="new name")

    //For referential comparison you can use === sign.  In the below cases, as the reference is not pointing to the same object, the below control flow will land on Entity classes are not equal.

    val entity7 = SealedEntity.Easy("1234", "name")
    val entity8 = SealedEntity.Easy("1234", "name")
    if(entity7 === entity8) {
        println("Entity classes are equal")
    } else {
        println("Entity classes are not equal")
    }

}