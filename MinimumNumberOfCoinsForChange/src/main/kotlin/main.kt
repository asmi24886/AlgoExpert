import kotlin.math.min

fun main(args: Array<String>) {
    println("Hello World!")

    minNumberOfCoinsForChange(7, listOf(2, 4)).also { println(it) }
}

fun minNumberOfCoinsForChange(n: Int, denom: List<Int>) : Int {

    denom.sorted()

    val mTable = MutableList(denom.size+1) { MutableList(n+1) {n+1} }

    for(i in mTable.indices) {
        mTable[i][0] = 0
    }

    for(i in 1 until mTable.size) {

        for(j in 1 until mTable[0].size) {

            if(denom[i-1] > j) {
                mTable[i][j] = mTable[i-1][j]
            }
            else {
                mTable[i][j] = min(mTable[i-1][j], mTable[i][j-denom[i-1]] + 1)
            }
        }
    }

    return mTable.last().last().let { if(it > n) -1 else it}
}