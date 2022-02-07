class EnumClasses


//Similar to Enums in java
enum class EntityType {
    EASY, MEDIUM, HARD,HELP;
    fun getFormattedName() = name.toLowerCase().capitalize()
}