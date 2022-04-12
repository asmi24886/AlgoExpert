import kotlin.math.abs

fun main(args: Array<String>) {
    println("Hello World!")
}

fun firstDuplicateValue(array: MutableList<Int>): Int {

    for(num in array) {
        val absNum = abs(num)
        if(array[absNum-1] < 0) return absNum else array[absNum-1]*=-1
    }

    return -1
}
