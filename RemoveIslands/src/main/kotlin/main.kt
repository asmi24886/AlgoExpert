fun main(args: Array<String>) {
    removeIslands(
        listOf(
            mutableListOf(1, 0, 0, 0, 0, 0),
            mutableListOf(0, 1, 0, 1, 1, 1),
            mutableListOf(0, 0, 1, 0, 1, 0),
            mutableListOf(1, 1, 0, 0, 1, 0),
            mutableListOf(1, 0, 1, 1, 0, 0),
            mutableListOf(1, 0, 0, 0, 0, 1)

        )
    ).also {
        println("$it")
    }
}

fun isOnEdge(i: Int, j: Int, rowLen: Int, colLen: Int): Boolean {
    return i == 0 || j == 0 || i == rowLen -1 || j == colLen -1
}

fun removeIslands(matrix: List<MutableList<Int>>): List<MutableList<Int>> {

    val visitedMatrix = List(matrix.size) {
        MutableList(matrix[0].size) {
            false
        }
    }

    for(i in matrix.indices) {
        for(j in matrix[0].indices) {
            if( isOnEdge(i, j, matrix.size, matrix[0].size) && matrix[i][j] == 1) {
                traverseChildrenAndMarkVisited(i, j, matrix, visitedMatrix)
            }
        }
    }
    for(k in matrix.indices) {
        for(l in matrix[0].indices) {
            if(visitedMatrix[k][l].not()) {
                matrix[k][l] = 0
                visitedMatrix[k][l] = true
            }
        }
    }

    return matrix
}

fun traverseChildrenAndMarkVisited(i: Int, j: Int, matrix: List<MutableList<Int>>, visitedMatrix: List<MutableList<Boolean>>) {

    if(visitedMatrix[i][j]) {
        return
    }
    visitedMatrix[i][j] = true

    findAdjascentNodes(i, j, matrix, visitedMatrix).forEach {
        traverseChildrenAndMarkVisited(it.first, it.second, matrix, visitedMatrix)
    }
}

fun findAdjascentNodes(i: Int, j: Int, matrix: List<MutableList<Int>>, visitedMatrix: List<MutableList<Boolean>>): List<Pair<Int, Int>> {
    val top    = if(i==0 || visitedMatrix[i-1][j] || matrix[i-1][j] == 0) null else Pair(i-1, j)
    val bottom = if(i==visitedMatrix.size-1 || visitedMatrix[i+1][j] || matrix[i+1][j] == 0) null else Pair(i+1, j)
    val left   = if(j==0 || visitedMatrix[i][j-1] || matrix[i][j-1] == 0) null else Pair(i, j-1)
    val right  = if(j==visitedMatrix[0].size-1 || visitedMatrix[i][j+1] || matrix[i][j+1] == 0) null else Pair(i, j+1)


    return listOfNotNull(top, bottom, left, right)
}
