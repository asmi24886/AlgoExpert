fun main(args: Array<String>) {
    println("Hello World!")
}

fun binarySearch(array: List<Int>, target: Int): Int {
    // Write your code here.
    if(array.isEmpty())
        return -1

    if(array.size == 1 && array.first() != target)
        return -1

    return search(0, array.size-1, array, target)
}

fun search(lowerIndex: Int, upperIndex: Int, array: List<Int>, target: Int): Int {
    if(upperIndex == lowerIndex) {
        return if(target == array[upperIndex]) upperIndex else -1
    }

    val mid = (upperIndex + lowerIndex)/2

    if(array[mid] == target)
        return mid

    if(target < array[mid])
        return search(lowerIndex, mid-1, array, target)
    else
        return search(mid+1, upperIndex, array, target)
}