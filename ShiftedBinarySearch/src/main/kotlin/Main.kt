fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun shiftedBinarySearch(array: List<Int>, target: Int): Int {
    if(array.isEmpty())
        return -1

    if(array.size == 1 && array[0] != target)
        return -1

    return search(0, array.size-1, array, target)

}

fun search(start: Int, end: Int, array: List<Int>, target: Int ) : Int {

    val mid = (start+end)/2

    if(array[mid] == target)
        return mid

    if(start == end)
        return -1

    val isMidInRotatedSection = array[start] > array[mid]

    if(target > array[mid]) {

        if(isMidInRotatedSection) {
            if(target > array[end]) {
                return search (start, mid-1, array, target)
            }
        }

        return search(mid+1, end, array, target)
    }
    else {
        if(!isMidInRotatedSection) {
            if(target < array[start]) {
                return search(mid+1, end, array, target)
            }
        }

        return search(start, mid-1, array, target)
    }

}