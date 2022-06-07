fun main(args: Array<String>) {
    groupAnagrams(listOf("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")).also { println(it) }
}

fun groupAnagrams(words: List<String>): List<List<String>> {

    val map = mutableMapOf<String, MutableList<String>>()

    words.forEach {
        val sorted = getSortedString(it)
        val list = map[sorted] ?: mutableListOf()
        list.add(it)
        map[sorted] = list
    }

    return map.values.toList()
}

fun getSortedString(string: String) = string.asSequence().sorted().joinToString("")