fun main(args: Array<String>) {
    println("Hello World!")
}

fun nonAttackingQueens(n: Int): Int {
    // iterate and try to place in number of squares on top
    var totalWays = 0
    for(i in 0 until n) {
        val coordinatesList = mutableListOf(Coordinates(0, i)) // place first 1

        for(j in 1 until n) {
            val placed = findNextPlacement(n, coordinatesList)

            if(placed!= null) {
                coordinatesList.add(placed)
            }
        }

        if(coordinatesList.size == n) {
            totalWays++
        }
    }
    return totalWays
}

fun findNextPlacement(n: Int, coordinateList: MutableList<Coordinates>) : Coordinates? {
    for(i in 0 until n) {
        for(j in 0 until n) {
            val cij = Coordinates(i, j)
            if(canAttack(cij, coordinateList).not()) {
                return cij
            }
        }
    }

    return null
}

fun canAttack(c1: Coordinates, coordinateList: MutableList<Coordinates>) : Boolean {
    for(i in coordinateList.indices) {
        if(c1.canAttack(coordinateList[i])) return true
    }

    return false
}

data class Coordinates(var x: Int, var y: Int) {

    fun canAttack(c: Coordinates) : Boolean {

        if(this.x == c.x || this.y == c.y || this.slope(c) == 1.0) {
            return true
        }

        return false
    }

    fun slope(c : Coordinates) : Double {
        return Math.abs((c.x - this.x).toDouble() / (c.y - this.y).toDouble())
    }
}