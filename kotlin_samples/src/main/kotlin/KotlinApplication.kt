import exception.MarriedException
import util.joinToString

fun main(args: Array<String>) {
    val bob = Person("Bob")
    val ann = Person("Ann")
    val undefinedWhore = Person("Sabrina")

    try {
        bob.marryMe(ann)
        bob.marryMe(undefinedWhore)
    } catch (e: MarriedException) {
        println("Caused an error in ${e.stackTrace[0].methodName}: ${e.message}")
    }

    val tags = listOf("Hello", "world", "collection", "sample")
    println("Default:\n\t ${joinToString(tags)}")
    println("Separator is \"?\":\n\t ${joinToString(tags, "?")}")
    println("Prefix is \"tags:\":\n\t ${joinToString(tags, prefix = "tags: ")}")
}






