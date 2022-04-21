import kotlin.math.min

fun main(args: Array<String>) {
    println("Hello World!")

    minNumberOfCoinsForChangeRecursive(7, listOf(3,7)).also { println(it) }
}

fun minNumberOfCoinsForChange(n: Int, denoms: List<Int>) : Int {

    denoms.sorted()

    val mTable = MutableList(denoms.size+1) { MutableList(n+1) {n+1} }

    for(i in mTable.indices) {
        mTable[i][0] = 0
    }

    for(i in 1 until mTable.size) {

        for(j in 1 until mTable[0].size) {

            if(denoms[i-1] > j) {
                mTable[i][j] = mTable[i-1][j]
            }
            else {
                mTable[i][j] = min(mTable[i-1][j], mTable[i][j-denoms[i-1]] + 1)
            }
        }
    }

    return mTable.last().last().let { if(it > n) -1 else it}
}

fun minNumberOfCoinsForChangeRecursive(n: Int, denoms: List<Int>) : Int {

    val mTable = MutableList(denoms.size+1) { MutableList(n+1){Integer.MAX_VALUE} }
    return findMinimumChanges(denoms.size, n, mTable, denoms.sorted())
        //.also { mTable.forEach{ println(it)} }
}

fun findMinimumChanges(m: Int, n: Int, mTable: MutableList<MutableList<Int>>, denoms: List<Int>) : Int {
    //println("$m ++++++++++++++++ $n")
    mTable[m][n] =
    when {
        n == 0 -> 0
        //change is still not zero, but i do not want to take any coins from last to first then it will be infinite number of turns
        m == 0 -> Integer.MAX_VALUE

        mTable[m][n] != Integer.MAX_VALUE -> mTable[m][n]
        //if the change i need to make is less than what i want to subtract from the choice of coins then just send back last count
        denoms[m-1] > n -> findMinimumChanges(m-1, n, mTable, denoms)
        else -> min(
                    findMinimumChanges(m-1, n, mTable, denoms),
                1 + findMinimumChanges(m, n- denoms[m-1], mTable, denoms).let { if(it == Int.MAX_VALUE) Int.MAX_VALUE-1 else it }
                )
    }
    //println("$m ........... $n >>>>>>>>> ${mTable[m][n]}")
    return mTable[m][n]
}