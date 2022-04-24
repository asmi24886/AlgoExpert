import kotlin.math.max

fun main(args: Array<String>) {
    println("Hello World!")
    longestCommonSubsequence("ZXVVYZW", "XKYKZPW").let {
        println(it)
    }
}

fun longestCommonSubsequence(str1: String, str2: String): List<Char> {
    // Write your code here.
    return longestCommonSubsequenceDp(str1, str2)
}

fun longestCommonSubsequenceDp(str1: String, str2: String): List<Char> {
    // Write your code here.
    val mTable = MutableList(str1.length + 1) { MutableList(str2.length + 1) {0} }

    for( i in 1 until mTable.size) {

        for (j in 1 until mTable[0].size) {

            if(str1[i-1] == str2[j-1]) {
                mTable[i][j] = 1 + mTable[i-1][j-1]
            }
            else {
                mTable[i][j] = max(mTable[i-1][j], mTable[i][j-1])
            }
        }
    }
    mTable.forEach {
        println(it)
    }
    return backTrack(str1, mTable)
}

fun backTrack(str: String, mTable:MutableList<MutableList<Int>>) : List<Char> {

    var i = mTable.size - 1
    var j = mTable[0].size - 1
    var result = mutableListOf<Char>()
    while (mTable[i][j] != 0) {
        if(mTable[i-1][j] == mTable[i][j]) {
            i--
        }
        else if(mTable[i][j-1] == mTable[i][j]) {
            j--
        }
        else if(mTable[i-1][j-1] == mTable[i][j] - 1 ) {
            result.add(str[i-1])
            i--
            j--
        }
    }

    return result.reversed()
}

fun longestCommonSubsequenceRecursive(str1: String, str2: String, i: Int, j: Int): MutableList<Char> {
    if(i == -1 || j == -1) {
        return mutableListOf()
    }

    return if(str1[i] == str2[j]) {
        longestCommonSubsequenceRecursive(str1, str2, i - 1 , j - 1).let {
            it.add(str1[i])
            it
        }
    }
    else {
        val result1 = longestCommonSubsequenceRecursive(str1, str2, i - 1 , j)
        val result2 = longestCommonSubsequenceRecursive(str1, str2, i, j - 1)

        if(result1.size >= result2.size) result1 else result2
    }
}