fun main(args: Array<String>) {
    println("Hello World!")
}

fun productSum(array: List<*>): Int {
    return getProductSum(array, 1)
}

fun getProductSum(array: List<*>, depth: Int) : Int {

    var sum = 0
    array.forEach {
        sum += when(it) {
            is Int -> it
            is List<*> -> getProductSum(it, depth + 1)
            else -> 0
        }
    }
    return depth*sum
}