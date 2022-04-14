fun main(args: Array<String>) {
    println("Hello World!")
    mergeOverlappingIntervals(
        listOf(
            listOf(1, 2),
            listOf(3, 5),
            listOf(4, 7),
            listOf(6, 8),
            listOf(9, 10)
        )
    ).also { println(it) }
}

fun mergeOverlappingIntervals(_intervals: List<List<Int>>): MutableList<MutableList<Int>> {

    var outputList = mutableListOf<MutableList<Int>>()
    val intervals = _intervals.sortedBy { it.first() }
    var low = intervals[0][0]
    var high = intervals[0][1]

    for(i in 1 until intervals.size) {

        var item = intervals[i]

        if(item[0] > high) {
            outputList.add(mutableListOf(low, high))
            low = item[0]
            high = item[1]

        }
        else {

            if(item[0] < low) {
                low = item[0]
            }

            if(item[1] > high) {
                high = item[1]
            }
        }

        if(i == intervals.size - 1) {
            outputList.add(mutableListOf(low, high))
        }
    }

    return outputList
}