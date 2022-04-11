fun main(args: Array<String>) {
    println("Hello World!")
}

fun spiralTraverse(array: List<List<Int>>): List<Int> {

    val traversalList = mutableListOf<Int>()

    var traversalDirection = 1 //1 - right, 2 - bottom, 3 - left, 4 - up
    var iStart = 0
    var jStart = 0
    var iEnd = array.size - 1
    var jEnd = array[0].size - 1

    while(traversalList.size != array.size*array[0].size) {

        if(traversalDirection == 1) {
            traverseLeft(iStart, jStart, jEnd, array).also { traversalList.addAll(it) }
            iStart+=1
            traversalDirection = 2
        }
        else if(traversalDirection == 2) {
            traverseBottom(iStart, jEnd, iEnd, array).also { traversalList.addAll(it) }
            jEnd-=1
            traversalDirection = 3
        }
        else if(traversalDirection == 3) {
            traverseRight(iEnd, jEnd, jStart, array).also { traversalList.addAll(it) }
            iEnd--
            traversalDirection = 4
        }
        else {
            traverseUp(iEnd, iStart, jStart, array).also { traversalList.addAll(it) }
            jStart++
            traversalDirection = 1
        }
    }
    return listOf<Int>()
}

fun traverseRight(i: Int, j: Int, end: Int, array: List<List<Int>>): MutableList<Int> {
    val output = mutableListOf<Int>()
    var index = j

    while(index <= end) {
        output.add(array[i][index])
        index++
    }
    return output
}

fun traverseBottom(i: Int, j: Int, end: Int, array: List<List<Int>>): MutableList<Int> {
    val output = mutableListOf<Int>()
    var index = i

    while(index <= end) {
        output.add(array[index][j])
        index++
    }
    return output
}

fun traverseLeft(i: Int, j: Int, end: Int, array: List<List<Int>>): MutableList<Int> {
    val output = mutableListOf<Int>()
    var index = j

    while(index >= end) {
        output.add(array[i][index])
        index--
    }
    return output
}

fun traverseUp(i: Int, j: Int, end: Int, array: List<List<Int>>): MutableList<Int> {
    val output = mutableListOf<Int>()
    var index = i

    while(index >= end) {
        output.add(array[i][index])
        index--
    }
    return output
}