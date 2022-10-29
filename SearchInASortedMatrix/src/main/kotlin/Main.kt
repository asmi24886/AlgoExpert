fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}

fun searchInSortedMatrix(matrix: List<List<Int>>, target: Int): Pair<Int, Int> {
    // Write your code here.
    if(matrix.isEmpty())
        return Pair(-1, -1)

    var row = 0
    var col = matrix[0].size -1

    while(row < matrix.size && col >= 0) {

        val value = matrix[row][col]
        if(value == target) return Pair(row, col)
        else if (value > target) {
            col--
        }
        else {
            row++
        }
    }

    return Pair(-1, -1)
}
