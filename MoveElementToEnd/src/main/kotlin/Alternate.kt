fun moveElementToEndAlt(array: MutableList<Int>, toMove: Int): List<Int> {

    if(array.isEmpty())
        return array

    var swapIndex = findSwapIndex(array, 0, array.size, toMove)

    if(swapIndex == 0) {
        return array
    }

    for(i in array.indices) {
        if(array[i] == toMove) {
            array[i] = array[swapIndex]
            array[swapIndex] = toMove
            swapIndex = findSwapIndex(array, 0, swapIndex, toMove)
        }

        if(swapIndex == i) {
            return array
        }
    }

    return array
}

fun findSwapIndex(array: MutableList<Int>, currentIndex: Int, lastSwapIndex: Int, toMove: Int) : Int{
    for(i in lastSwapIndex-1 downTo currentIndex) {
        if(array[i] != toMove) {
            return i
        }
    }

    return currentIndex
}