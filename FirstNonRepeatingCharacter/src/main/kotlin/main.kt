fun main(args: Array<String>) {
    println("Hello World!")
}

fun firstNonRepeatingCharacter(string: String): Int {
    return string
        .groupingBy { it }
        .eachCount()
        .entries.firstOrNull {
            it.value == 1
        }.let {  e ->
            if(e == null) -1
            else string.indexOf(e.key, 0)
        }
}