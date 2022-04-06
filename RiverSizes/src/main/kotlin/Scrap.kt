/*


class Node() {
    val children = mutableListOf<Node>()
}

fun initNodeMatrix(row:Int, col: Int, nodeMatrix: MutableList<MutableList<Node?>>): MutableList<MutableList<Node?>> {
    var i = row

    while(i!=0) {
        val newList = mutableListOf<Node?>()
        var j = col
        while(j!=0) {
            newList.add(null)
            j--
        }
        nodeMatrix.add(newList)
        i--
    }

    return nodeMatrix
}

fun riverSizes(matrix: List<List<Int>>): List<Int> {
    var i=0
    var j = 0
    val outputNodeList = mutableListOf<Node>()
    val nodeMatrix = initNodeMatrix(matrix.size, matrix[0].size, mutableListOf() )

    while(i < matrix.size) {
        j=0

        while(j < matrix[i].size) {

            if(matrix[i][j] == 1) {
                nodeMatrix[i][j] = Node()

                if(linkNodeToExistingGraph(i, j, nodeMatrix))
                    outputNodeList.add(nodeMatrix[i][j]!!)
            }

            j++
        }
        i++
    }

    return outputNodeList.map {
        countChildren(it)
    }
}

fun linkNodeToExistingGraph(i: Int, j: Int, nodeMatrix: MutableList<MutableList<Node?>>): Boolean {
    val top = if(i==0) null else nodeMatrix[i-1][j]
    val bottom = if(i==nodeMatrix.size-1) null else nodeMatrix[i+1][j]
    val left = if(j==0) null else nodeMatrix[i][j-1]
    val right = if(j==nodeMatrix.size-1) null else nodeMatrix[i][j+1]

    val adjascentNode = listOf(top, bottom, left, right).firstOrNull { it != null } ?: return true
    adjascentNode?.children?.add(nodeMatrix[i][j]!!)
    return false
}

fun countChildren(node: Node): Int {
    val q = LinkedList<Node>()
    q.offer(node)
    var count = 0
    while(q.isNotEmpty()) {
        val thisNode = q.remove()
        count++
       q.addAll(thisNode.children)
    }
    return count
}

 */