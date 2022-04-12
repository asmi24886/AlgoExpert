fun main(args: Array<String>) {
    println("Hello World!")
}

fun arrayOfProducts(array: List<Int>): List<Int> {
    val rightProducts = MutableList(array.size) {1}
    val leftProducts = MutableList(array.size) {1}

    var product = 1
    for(i in array.indices) {
        leftProducts[i] = product
        product*= array[i]
    }

    product = 1
    for(j in array.size - 1 downTo 0) {
        rightProducts[j] = product
        product*=array[j]
    }

    val outputArr = mutableListOf<Int>()

    for(k in array.indices) {
        outputArr.add(leftProducts[k] * rightProducts[k])
    }

    return outputArr
}