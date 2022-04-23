fun main(args: Array<String>) {
    numberOfWaysToTraverseGraph(4,3).also {
        println(it)
    }
}

fun numberOfWaysToTraverseGraph(width: Int, height: Int): Int {
    val mTable = MutableList(height+1) { MutableList(width + 1) { 0 } }
    mTable[height-1][width-1] = 1
    return getTotalWaysFromCurrentNodeDp(height, width, mTable)//.also { mTable.forEach { println(it) } }
}

fun getTotalWaysFromCurrentNodeRecursive(i: Int, j: Int, mt: MutableList<MutableList<Int>>) : Int {

    if(i == mt.size - 1 || j == mt[0].size - 1 || mt[i][j] != 0) {
        return mt[i][j]
    }

    mt[i][j] = getTotalWaysFromCurrentNodeRecursive(i+1, j, mt) + getTotalWaysFromCurrentNodeRecursive(i, j+1, mt)
    return mt[i][j]
}

fun getTotalWaysFromCurrentNodeDp(height: Int, width: Int, mt: MutableList<MutableList<Int>>) : Int {

    for(i in height-1 downTo 0) {
        for(j in width-1 downTo 0) {
            if(mt[i][j] == 0) {
                mt[i][j] = mt[i+1][j] + mt[i][j+1]
            }
        }
    }

    return mt[0][0]
}