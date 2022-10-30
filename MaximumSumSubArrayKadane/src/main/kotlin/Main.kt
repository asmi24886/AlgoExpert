fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun kadanesAlgorithm(array: List<Int>): Int {
    var maxSum = array[0]
    var sumUptoNow = array[0]

    for(i in 1 until array.size) {
        sumUptoNow = Math.max(array[i], sumUptoNow+array[i])

        if(maxSum < sumUptoNow) {
            maxSum = sumUptoNow
        }
    }

    return maxSum
}
