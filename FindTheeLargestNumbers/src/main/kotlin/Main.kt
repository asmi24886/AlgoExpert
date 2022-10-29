fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun findThreeLargestNumbers(array: List<Int>): List<Int> {

    if(array.size < 3)
        return emptyList()

    var list = MutableList(3) {Int.MIN_VALUE}

    array.forEach {

        var toAdjustIndex = -1

        if(it > list[0]) {
            toAdjustIndex = 0
        }
        else if(it > list[1]) {
            toAdjustIndex = 1
        }
        else if(it > list[2]) {
            toAdjustIndex = 2
        }

        if(toAdjustIndex >= 0) {
            list = adjustFinalList(list, toAdjustIndex, it)
        }
    }

    return list.reversed()
}

fun adjustFinalList(list: MutableList<Int>, index: Int, num: Int): MutableList<Int> {

    if(list.size <= index) {
        return list
    }

    var temp = list[index]
    for(i in index until 2) {

        if(i < 2) {
            val next = list[i+1]
            list[i+1] = temp
            temp = next
        }
    }

    list[index] = num
    return list
}