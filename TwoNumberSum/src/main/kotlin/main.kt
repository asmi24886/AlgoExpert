import com.sun.org.apache.xpath.internal.operations.Bool

fun main(args: Array<String>) {
    println("Hello World!")
}

fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {

    val computed = mutableMapOf<Int, Boolean>()
    val output = mutableListOf<Int>()
    for(num in array) {
        if(computed[targetSum - num] == true) {
            output.addAll(listOf(num, targetSum-num))
            return output
        }

        computed[num] = true
    }
    // Write your code here.
    return listOf()
}

fun twoNumberSumAlternate(array: MutableList<Int>, targetSum: Int): List<Int> {
    array.sort() //nLog(n)

    var lower = 0
    var upper = array.size-1

    while(lower < upper) {

        val lowerVal = array[lower]
        val upperVal = array[upper]
        val sum = lowerVal+upperVal
        if(sum == targetSum) return listOf(lowerVal, upperVal)
        when {
            sum > targetSum -> upper--
            sum < targetSum -> lower++
        }
    }

    return emptyList()
}