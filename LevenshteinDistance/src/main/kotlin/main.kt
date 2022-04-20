fun main(args: Array<String>) {
    levenshteinDistance("abc", "yabd").also {
        println(it)
    }
}

fun levenshteinDistance(str1: String, str2: String): Int {
    val mTable = MutableList(str1.length) { MutableList(str2.length) {-1} }
    return levenshteinDistanceRecursive(str1, str2, Pair(0, 0), mTable)//.also { mTable.forEach{ println(it)} }
}

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