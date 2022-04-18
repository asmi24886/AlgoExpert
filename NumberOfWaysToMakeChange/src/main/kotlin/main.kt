fun main(args: Array<String>) {
    println("Hello World!")

    numberOfWaysToMakeChange(10, listOf(1,5,10, 25)).also { println(it) } //1+1+1+1+1 , 1+1+1+2, 1+1+3, 2+2+1, 2+3
}

fun numberOfWaysToMakeChange(n: Int, denoms: List<Int>): Int {

    if(n == 0) {
        return 1
    }

    if(denoms.isEmpty()) {
        return 0
    }

    val mTable = MutableList(denoms.size+1) { MutableList(n+1) { 0 } }
    denoms.sorted()

    for(i in mTable.indices) {
        mTable[i][0] = 1
    }

    for(i in 1 until mTable.size) {

        for(j in 1 until mTable[0].size) {

            val denom = denoms[i-1]

            if(denom > j) {
                mTable[i][j] = mTable[i-1][j]
            }
            else {
                mTable[i][j] = mTable[i-1][j] + mTable[i][j-denom]
            }
        }
    }
    return mTable.last().last()
}