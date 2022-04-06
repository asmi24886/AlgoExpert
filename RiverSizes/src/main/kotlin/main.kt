fun main(args: Array<String>) {
  riverSizes(
      listOf(
          mutableListOf(1, 0, 0, 1, 0),
          mutableListOf(1, 0, 1, 0, 0),
          mutableListOf(0, 0, 1, 0, 1),
          mutableListOf(1, 0, 1, 0, 1),
          mutableListOf(1, 0, 1, 1, 0)

      )
  ).also {
      println("$it")
  }
}

fun riverSizes(matrix: List<List<Int>>): List<Int> {

    val visitedMatrix = initVisitedMatrix(matrix.size, matrix[0].size)
    val outputCountList = mutableListOf<Int>()
    var i=0

    while(i < matrix.size) {
        var j=0

        while(j < matrix[i].size) {

            if(!visitedMatrix[i][j] && matrix[i][j] == 1) {

                outputCountList.add(
                    getCountOfConnectedChildren(i, j, matrix, visitedMatrix)
                )
            }

            j++
        }
        i++
    }

    return outputCountList
}

fun initVisitedMatrix(row:Int, col: Int): MutableList<MutableList<Boolean>> {

    return MutableList(row) {
        MutableList(col) {
            false
        }
    }
}

fun getCountOfConnectedChildren(i: Int, j: Int, matrix: List<List<Int>>, visitedMatrix: MutableList<MutableList<Boolean>>) : Int {
    var childrenCount = 0
    if(visitedMatrix[i][j]) return childrenCount
    visitedMatrix[i][j] = true

    val top    = if(i==0 || visitedMatrix[i-1][j] || matrix[i-1][j] == 0) null else Pair(i-1, j)
    val bottom = if(i==visitedMatrix.size-1 || visitedMatrix[i+1][j] || matrix[i+1][j] == 0) null else Pair(i+1, j)
    val left   = if(j==0 || visitedMatrix[i][j-1] || matrix[i][j-1] == 0) null else Pair(i, j-1)
    val right  = if(j==visitedMatrix[0].size-1 || visitedMatrix[i][j+1] || matrix[i][j+1] == 0) null else Pair(i, j+1)


    listOfNotNull(top, bottom, left, right).forEach {
        childrenCount += getCountOfConnectedChildren(it.first, it.second, matrix, visitedMatrix)
    }

    return childrenCount + 1
}