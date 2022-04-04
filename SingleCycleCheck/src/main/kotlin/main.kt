fun main(args: Array<String>) {
    println(-1 % 6)
}

fun hasSingleCycle(array: List<Int>): Boolean {

    val totalElements = array.size
    var visitedElements = 0
    var index = 0

    while(visitedElements < totalElements) {
        if(visitedElements > 0 && index == 0) return false
        val tempIndex = (index + array[index]) % totalElements
        index = if(tempIndex >= 0) tempIndex else (totalElements + tempIndex)
        visitedElements++
    }

    return index == 0
}