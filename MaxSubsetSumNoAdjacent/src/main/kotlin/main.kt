import kotlin.math.max

fun main(args: Array<String>) {
    println("Hello World!")
}

/*
    bottom up approach - at each index we have to consider what if the array was up until this
    example [15, 3, 25, 8]

    if only [15] -> 15
    if only [15, 3] -> upto index 1 iteration max would have been 15 -> [15, 15]
    if [15, 3, 25] -> upto index 2 iteration max would have been 25+15 -> [15, 15, maxOf(25+15, 15{3})=40]
    if [15, 3, 25, 8] -> [15, 15, 40, maxOf(15+8, 40)] and so on so forth

    The idea is to first divide the problem into the smallest possible sub problem and then add up
 */

fun maxSubsetSumNoAdjacent(array: MutableList<Int>): Int {

    if(array.isEmpty()) return 0
    if(array.size==1) return array.first()

    array[1] = max(array[0], array[1]) //bottom up

    for (i in 2 until array.size) {
        array[i] = max(
            array[i-1], array[i-2] + array[i]
        )
    }

    return array.last()
}

fun maxSubsetSumNoAdjacentRecursive(array: List<Int>): Int {
    if(array.isEmpty()) { return 0 }
    if(array.size == 1) {return array.first()}

    val mTable = MutableList(array.size){0}
    return max(
        findMaxNonAdjacentSum(0, array, mTable),
        findMaxNonAdjacentSum(1, array, mTable)
    )
}

fun findMaxNonAdjacentSum(i: Int, array: List<Int>, mTable: MutableList<Int>): Int {

    if(i+1 > array.size) {
        return 0
    }

    if(mTable[i] != 0) {
        return mTable[i]
    }
    mTable[i] = array[i] + max(
        findMaxNonAdjacentSum(i+2, array, mTable),
        findMaxNonAdjacentSum(i+3, array, mTable)
    )


    return mTable[i]
}