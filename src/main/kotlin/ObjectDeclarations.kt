import EntityType.*
import java.util.*

class ObjectDeclarations

/*
   Object declarations are a convenient ways of defining thread safe singletons. They can be useful to explain EnumClasses
 */

class EntityClass(val id:String, val name:String) {
    override fun toString(): String {
        return "id:$id :: name:$name"
    }
}



object ObjectEntityFactory {
    fun create(type:EntityType) : EntityClass {
        val id = UUID.randomUUID().toString()
        val name = when(type) {
            EASY -> type.getFormattedName()
            MEDIUM -> type.getFormattedName()
            HARD -> type.getFormattedName()
            HELP -> type.getFormattedName()
        }
        return EntityClass(id,name)
    }
}


fun main() {
    var entity = ObjectEntityFactory.create(EASY)
}