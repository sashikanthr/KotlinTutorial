class ExtensionFunctionsProperties

/*
    This is a powerful feature where you can control how the classes can be modified for usage. You can extend classes. Within the Kotlin library, there are many operations defined using extension functions. They are particularly effective when using them with templated types because it allows them to define a common functionality across any typo that matched the templates.
 */

//Extending a function

fun SealedEntity.Medium.printInfo() {
    println("Modifying Medium data classes to demo extension function or properties")
}

//Extending a property. You will need a backing field. Need to verify how this is enforced
val SealedEntity.Medium.info: String
    get() = "Extension Property"

fun main() {
    val entity  = SealedEntityFactory.create(EntityType.MEDIUM)
    if(entity is SealedEntity.Medium) {
        entity.printInfo()
        println(entity.info)
    }
}