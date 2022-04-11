fun main(args: Array<String>) {
    println("Hello World!")
}

class MonotonicResult {
    var increasing = false
    var decreasing = false
}

fun isMonotonic(array: List<Int>): Boolean {
    val result  = MonotonicResult()

    for(index in 0 until array.size -1) {
        if(array[index] > array[index+1]) {
            result.increasing=true
        }
        else if(array[index] < array[index+1]) {
            result.decreasing = true
        }

        if(result.increasing && result.decreasing) {
            return false
        }
    }

    return true
}