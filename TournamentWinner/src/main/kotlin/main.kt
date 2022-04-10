fun main(args: Array<String>) {
    println("Hello World!")
}

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {

    val map = mutableMapOf<String, Int>()

    var maxWon = ""
    var maxWonCount = 0

    for(i in results.indices) {
        val result = results[i]

        if(map[competitions[i][0]] == null) {
            map[competitions[i][0]] = 0
        }

        if(map[competitions[i][1]] == null) {
            map[competitions[i][1]] = 0
        }

        if(result == 1) {
            map[competitions[i][0]] = map[competitions[i][0]]!! + 1
        }
        else {
            map[competitions[i][1]] = map[competitions[i][1]]!! + 1
        }

        if(map[competitions[i][0]]!! > maxWonCount) {
            maxWonCount = map[competitions[i][0]]!!
            maxWon = competitions[i][0]
        }
        else if(map[competitions[i][1]]!! > maxWonCount) {
            maxWonCount = map[competitions[i][1]]!!
            maxWon = competitions[i][1]
        }
    }

    return maxWon
}