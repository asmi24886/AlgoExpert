import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
}

//This solution is more memort optimized due to not initializing new queues at every pass
// thereby utilizing the same quueue using a pass marker
fun minimumPassesOfMatrix(matrix: MutableList<MutableList<Int>>): Int {

    var pass = 0
    var totalNegatives = 0
    val q: Queue<Pair<Int, Int>> = LinkedList()

    //find all positive numbers in the matrix
    for(i in matrix.indices) {
        for(j in matrix[i].indices) {
            if(matrix[i][j] > 0) {
                q.offer(Pair(i, j))
            }
            else if(matrix[i][j] < 0) {
                totalNegatives++
            }
        }
    }

    //Let this be the pass marker
    q.offer(Pair(-1, -1))

    while(q.size != 1) {

        var nextItem = q.remove()

        //pass marker reached, lets increase the pass count
        if(nextItem.first == -1) {
            pass++
            q.offer(nextItem)
            continue
        }

        val convertedNeighbours = convertAndGetNeighbours(nextItem, matrix)
        totalNegatives -= convertedNeighbours.size
        q.addAll(convertedNeighbours)
    }
    return if(totalNegatives == 0) pass else -1
}

fun convertAndGetNeighbours(node: Pair<Int, Int>, matrix: MutableList<MutableList<Int>>): List<Pair<Int, Int>> {

    val top = if(node.first == 0 || matrix[node.first-1][node.second] >= 0) null else Pair(node.first-1, node.second)
    val bottom = if(node.first == matrix.size-1 || matrix[node.first+1][node.second] >= 0) null else Pair(node.first+1, node.second)

    val left = if(node.second == 0 || matrix[node.first][node.second-1] >= 0) null else Pair(node.first, node.second-1)
    val right = if(node.second == matrix[node.first].size - 1 || matrix[node.first][node.second+1] >= 0) null else Pair(node.first, node.second+1)

    //Can replace with 4 if statements or a when clause but that will be really ugly code I suppose
    return mutableListOf(top, bottom, left, right)
        .filterNotNull()
        .let { list ->
            list.forEach { matrix[it.first][it.second] *= -1 }
            list
        }
}