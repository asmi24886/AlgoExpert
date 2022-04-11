import kotlin.math.abs

fun main(args: Array<String>) {
    println("Hello World!")
}

fun smallestDifference(arrayOne: MutableList<Int>, arrayTwo: MutableList<Int>): List<Int> {
    // Write your code here.

    arrayOne.sort()
    arrayTwo.sort()

    var firstP = 0
    var secondP = 0

    var closestToZeroDiff = -1
    var closestToZeroPair = mutableListOf<Int>()

    while(firstP < arrayOne.size && secondP < arrayTwo.size) {

        val diff = abs(arrayOne[firstP] - arrayTwo[secondP])

        if(closestToZeroDiff == -1 || diff < closestToZeroDiff) {
            closestToZeroDiff = diff
            closestToZeroPair = mutableListOf(arrayOne[firstP], arrayTwo[secondP])
        }

        if(diff == 0) {
            return closestToZeroPair
        }

        if(arrayOne[firstP] < arrayTwo[secondP]) {
            firstP++
        }
        else {
            secondP++
        }
    }

    return closestToZeroPair
}