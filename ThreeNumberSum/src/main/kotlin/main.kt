fun main(args: Array<String>) {
    println("Hello World!")
}

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    array.sort()

    val output = mutableListOf<List<Int>>()

    for(i in 0 until array.size - 2) {
        val twoNumberSumList = twoNumberSum(array, Pair(i+1, array.size-1), array[i], targetSum - array[i])
        if(twoNumberSumList.isNotEmpty()) {
            output.addAll(twoNumberSumList)
        }
    }
    return output
}

fun twoNumberSum(array: MutableList<Int>, pointers: Pair<Int, Int>, baseNumber: Int, targetSum: Int) : MutableList<MutableList<Int>> {

    var low = pointers.first
    var high = pointers.second

    val output = mutableListOf<MutableList<Int>>()

    while(low < high) {

        if(array[low] + array[high] == targetSum) {
            output.add(mutableListOf( baseNumber, array[low], array[high]) )
            low++
            high--
        }
        else if(array[low] + array[high] < targetSum) {
            low++
        }
        else {
            high--
        }
    }

    return output
}