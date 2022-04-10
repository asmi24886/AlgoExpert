fun main(args: Array<String>) {
    println("Hello World!")

    isValidSubsequence(listOf(5, 1, 22, 25, 6, -1, 8, 10), listOf(5, 1, 22, 25, 6, -1, 8, 10, 12)).also {
        println(it)
    }
}

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {

    var sequencePointer = 0
    for (index in array.indices) {
        if(array[index] == sequence[sequencePointer]) {
            sequencePointer++
        }

        //all nums in sequence matched
        //say if 0th index matches, next index becomes 1, total matched count is also 1
        //for a seq array of 5 elements, if all index matches, after matching 4th index from 0, next sequencePointer => 5 which is now also total matches
        if(sequencePointer == sequence.size) {
            return true
        }
    }

    return false
}