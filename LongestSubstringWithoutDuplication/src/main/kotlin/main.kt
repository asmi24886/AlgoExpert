fun main(args: Array<String>) {
    println(longestSubstringWithoutDuplication("clementisacap"))
}

fun longestSubstringWithoutDuplication(string: String): String {
    val charMap = mutableMapOf<Char, Int?>()

    var startIndex = 0

    var longestCount = 0
    var resultIndex = 0

    string.forEachIndexed { i, c ->
        if(charMap[c] != null) {
            //check for longest Count and update result index and count
            if(i-startIndex > longestCount) {
                resultIndex = startIndex
                longestCount = i - startIndex
            }

            //found new updated index to start counting from
            val newStartIndex = charMap[c]!! + 1

            //make other elements as prior to the previous index found as null
            for(j in startIndex..charMap[c]!!) {
                charMap[string[j]] = null
            }

            startIndex = newStartIndex
        }
        else if(i == string.lastIndex) {
            if(string.length-startIndex > longestCount) {
                resultIndex = startIndex
                longestCount = string.length - startIndex
            }
        }

        charMap[c] = i
    }

    return string.substring(resultIndex, resultIndex+longestCount)
}