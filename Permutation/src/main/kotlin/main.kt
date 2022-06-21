fun main(args: Array<String>) {
    println("Hello World!")
}

fun getPermutations(array: List<Int>): List<List<Int>> {

    if(array.isEmpty()) return mutableListOf()
    return doPermutation(array)
}

fun doPermutation(array: List<Int>) : MutableList<MutableList<Int>> {

    if(array.size == 1) {
        return mutableListOf(array.toMutableList())
    }

    return doPermutation(array.subList(1, array.size)).map { arr ->
        doInsert(arr, array.first())
    }.flatten().toMutableList()
}

fun doInsert(arr: List<Int>, value: Int) : MutableList<MutableList<Int>> {
    val result = mutableListOf<MutableList<Int>>()

    for(i in arr.indices) {
        result.add(arr.toMutableList().apply { add(i, value) })
    }

    result.add(
        arr.toMutableList().apply { add(value) }
    )

    return result
}