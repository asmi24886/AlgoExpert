fun main(args: Array<String>) {
    println("Hello World!")
}

fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {

    var i = 0
    var j = array.size -1

    while (i<j) {
        while(i<j && array[j] == toMove) j--
        if(array[i] == toMove) {
            array[j] = array[i]
            array[i] = toMove
        }
        i++
    }
    return array
}
