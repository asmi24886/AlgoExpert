import kotlin.math.min

fun main(args: Array<String>) {
    println("Hello World!")

    minNoOfCoinsToMakeChange(11, listOf(1, 2, 5)).also { println(it) }
}

fun minNoOfCoinsToMakeChange(n: Int, denom: List<Int>) : Int {

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

    return mTable.last().last()
}