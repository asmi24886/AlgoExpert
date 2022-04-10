fun main(args: Array<String>) {
    println("Hello World!")
}

fun sortedSquaredArray(array: List<Int>): List<Int> {

    var computedCount = 0
    var left = 0
    var right  = array.size - 1

    val output = MutableList(array.size){0}

    while(computedCount != array.size) {
        val leftNum = array[left]
        val rightNum = array[right]
        if( leftNum*leftNum >= rightNum*rightNum) {
            output[array.size - 1 - computedCount] = leftNum*leftNum
            left++
        }
        else {
            output[array.size - 1 - computedCount] = rightNum*rightNum
            right--
        }
        computedCount++
    }

    return output
}