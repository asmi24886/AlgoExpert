fun main(args: Array<String>) {
    levenshteinDistance("abc", "yabd").also {
        println(it)
    }
}

fun levenshteinDistance(str1: String, str2: String): Int {
    //val mTable = MutableList(str1.length) { MutableList(str2.length) {-1} }
    //return levenshteinDistanceRecursive(str1, str2, Pair(0, 0), mTable).also { mTable.forEach{ println(it)} }

    val mTable = MutableList(str1.length+1) { MutableList(str2.length+1) {-1} }
    return levenshteinDistanceFrontToBackDp(str1, str2, mTable).also { mTable.forEach{ println(it)} }
}

//Most tutorials give last to front recursive, this is front to last
fun levenshteinDistanceRecursive(str1: String, str2: String, pointers: Pair<Int, Int>, mTable: MutableList<MutableList<Int>>): Int {

    var (i, j) = pointers
    //println("$i ...... $j")

    if(i == str1.length) return (str2.length - j)//.also { println(">>>>>>> $it") }

    if(j == str2.length) return (str1.length - i)//.also { println("$$$$$ $it") }

    if(mTable[i][j] != -1) {
        return mTable[i][j]
    }

    mTable[i][j] =
        if(str1[i] != str2[j]) {
            val insert = levenshteinDistanceRecursive(str1, str2, Pair(i, j+1), mTable)
            val delete = levenshteinDistanceRecursive(str1, str2, Pair(i+1, j), mTable)
            val sub = levenshteinDistanceRecursive(str1, str2, Pair(i+1, j+1), mTable)
            1 + listOf(insert, delete, sub).sorted().first()
        }
        else {
           levenshteinDistanceRecursive(str1, str2, Pair(i+1, j+1), mTable)
        }

    return mTable[i][j]
}

/*
    How do we move to next sub problems? The recursive approach will give an idea.
    In recursion we were delegating the sub problems to recusrive functions until we reach the end
    The end call on the top of the call stack will return some value based on which we build up the rest

    In this approach first we arrange that value in the dp table. then follow understand how one single sub problem will work
    If we know that the rest will follow the same pattern

    What do we do if two chars dont match
    ----------------------------------------------

    mTable[i+1][j] -> delete from str1, move to next char on str1 (can reach null end), str2 remains on same char
    mTable[i][j+1] -> insert from str2, once inserted, move to next char on str2 (can reach null end), str1 remains on same char
    mTable[i+1][j+1] -> substitution means move both pointers

    Finally add 1 -> This is the cost of doing the operation (insert, delete or sub)

    If they match
    ----------------------------------------------------
    mTable[i+1][j+1] -> Cool, do not need to add anything to the return val of next sub problem as we do not do any operation

*/
fun levenshteinDistanceFrontToBackDp(str1: String, str2: String, mTable: MutableList<MutableList<Int>>): Int {

    var m = str1.length
    var n = str2.length

    for (i in m downTo 0) { mTable[i][n] = m - i }
    for(j in n downTo 0) { mTable[m][j] = n - j }

    for(i in m-1 downTo 0) {
        for(j in n-1 downTo 0) {
            mTable[i][j] = if(str1[i] == str2[j]) mTable[i+1][j+1] else 1 + listOf(mTable[i][j+1], mTable[i+1][j], mTable[i+1][j+1]).sorted().first()
        }
    }
    return mTable[0][0]
}