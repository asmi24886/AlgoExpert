fun main(args: Array<String>) {
    println(minimumCharactersForWords(listOf("this", "that", "did", "deed", "them!", "a")))
}

fun minimumCharactersForWords(words: List<String>): List<Char> {

    val resultMap = mutableMapOf<Char, Int>()

    words.map { s -> s.groupingBy { it }.eachCount()}
        .forEach { m ->
            m.entries.forEach {e ->
                val count = resultMap[e.key]?:0
                if(e.value > count) {
                    resultMap[e.key] = e.value
                }
            }
        }

    return resultMap.entries.map {
        val list = mutableListOf<Char>()
        for(i in 1..it.value) {
            list.add(it.key)
        }
        list
    }.flatten()
}