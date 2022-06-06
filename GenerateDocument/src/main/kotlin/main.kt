fun main(args: Array<String>) {
    println("Hello World!")
}

fun generateDocument(characters: String, document: String): Boolean {
    val charMap = characters.groupingBy { it }.eachCount()
    val docCharMap = document.groupingBy { it }.eachCount()
    var result = true
    docCharMap.keys.forEach {
        if(charMap[it]?:0 < docCharMap[it]!!) result = false
    }

    return result
}