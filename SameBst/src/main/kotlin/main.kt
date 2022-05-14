fun main(args: Array<String>) {
    println("Hello World!")
}

fun sameBsts(arrayOne: List<Int>, arrayTwo: List<Int>): Boolean {

    if(arrayOne.size != arrayTwo.size) return false
    if(arrayOne.isEmpty() && arrayTwo.isEmpty())return true
    if(arrayOne.firstOrNull() != arrayTwo.firstOrNull())return false

    val comparingValue = arrayOne.first()
    val arrayOnePartition = arrayOne.subList(1, arrayOne.size).partition { it < comparingValue }
    val arrayTwoPartition = arrayTwo.subList(1, arrayOne.size).partition { it < arrayTwo.first() }

    val leftBstResult = sameBsts(arrayOnePartition.first, arrayTwoPartition.first)

    if(!leftBstResult) return leftBstResult

    return sameBsts(arrayOnePartition.second, arrayTwoPartition.second)
}