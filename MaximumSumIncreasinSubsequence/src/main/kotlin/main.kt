fun main(args: Array<String>) {
    println("Hello World!")

    maxSumIncreasingSubsequence(listOf(10, 70, 20, 30, 50, 11, 30)).also { println(it) }
}

fun maxSumIncreasingSubsequence(array: List<Int>): Pair<Int, List<Int>> {
    // Write your code here.

    val mArr = MutableList(array.size){0}
    val connectedIndexArr = MutableList<Int?>(array.size){null}

    var maxSum = Int.MIN_VALUE
    var maxIndex = -1

    if(array.size == 1) {
        return Pair(array.first(), mutableListOf(array.first()))
    }

    for(i in array.size - 1 downTo 0) {
        val current = findMaxSum(i, mArr, connectedIndexArr, array)
        if(current > maxSum) {
            maxSum = current
            maxIndex = i
        }
    }

    //backtrack
    return Pair(maxSum, maxIndex.let {
        var i = it
        val list = mutableListOf(array[i])
        while(connectedIndexArr[i] != null) {
            i = connectedIndexArr[i]!!
            list.add(array[i])
        }
        list
    } )
}

fun findMaxSum(j: Int, mArr: MutableList<Int>, connectedIndexArr: MutableList<Int?>, array: List<Int>): Int {

    if(j == array.size -1 ) {
        if(mArr[j] == 0) {
            mArr[j] = array[j]

        }
        return mArr[j]
    }

    var k = j + 1
    var next: Int? = null
    var nextIndex: Int? = null
    while(k < array.size) {
        if(array[j] < array[k]) {
            if(next == null || mArr[k] > next) {
                next = mArr[k]
                nextIndex = k
            }
        }
        k++
    }

    if(next == null) {
        mArr[j] = array[j]
    }
    else {
        mArr[j] = array[j] + next
        connectedIndexArr[j] = nextIndex
    }

    return mArr[j]
}