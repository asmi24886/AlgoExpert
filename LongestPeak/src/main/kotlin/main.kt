import kotlin.math.max

fun main(args: Array<String>) {
    println("Hello World!")

    longestPeak(listOf(1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3)).also { println(it) }
}

//An alternate solution would be to find the peaks and then expand from both sides until a reverse slope is reached
fun longestPeak(array: List<Int>): Int {
    var wStart = 0
    var wEnd = 1

    var highestWindowLength = 0

    var isIncreasing = false
    var isDecreasing = false

    while(wEnd < array.size) {
        if(array[wEnd] > array[wEnd - 1]) {
            if(isDecreasing) {
                wStart = wEnd - 1
            }
            isDecreasing = false
            isIncreasing = true
        }
        else if(array[wEnd] == array[wEnd - 1]) {
            isIncreasing = false
            isDecreasing = false
            wStart = wEnd
        }
        else if(array[wEnd] < array[wEnd - 1]) {

            isDecreasing = true

            if(isIncreasing && isDecreasing) {
                highestWindowLength = max(highestWindowLength, wEnd - wStart + 1)
            }
        }
        wEnd++
    }

    return if(highestWindowLength >= 3) highestWindowLength else 0
}