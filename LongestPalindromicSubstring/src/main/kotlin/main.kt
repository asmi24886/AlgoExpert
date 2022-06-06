fun main(args: Array<String>) {
    println("abaxyzzyxf")
}

fun longestPalindromicSubstring(string: String): String {
    if(string.length == 1)
        return string

    var result = Triple(-1, -1, 0)

    for(pivot in 0 until string.length - 1) {
        val even = getLongestPalindrome(pivot, pivot+1, string)
        val odd = getLongestPalindrome(pivot, pivot+2, string)

        val currentresult = if(odd.third > even.third) {
            odd
        }
        else {
            even
        }

        if(currentresult.third > result.third) {
            result = currentresult
        }
    }

    return if(result.first == -1) "" else string.substring(result.first, result.second)
}

fun getLongestPalindrome(i: Int, j: Int, string: String) : Triple<Int, Int, Int> {
    var left = i
    var right = j
    var count = 0
    while(true) {
        if(left < 0 || right == string.length) {
            break
        }

        if(string[left] == string[right]) {
            count++
            left--
            right++
        }
        else {
            break
        }
    }

    return Triple(left+1, right,count)
}

fun longestCommonSubstring(string: String): String {
    val reversed = string.reversed()
    val dp = MutableList(string.length + 1) { MutableList(string.length + 1) {0} }

    var longestCount = 0
    for(i in 1 until dp.size) {
        for(j in 0 until dp.size) {

            if(string[i-1] == reversed[j - 1]) {
                dp[i][j] = 1 + dp[i-1][j-1]
                if(dp[i][j] > longestCount) {
                    longestCount = dp[i][j]
                }
            }
            else {
                dp[i][j] = 0
            }
        }
    }

    var endIndex = -1

    for(i in string.length downTo 1) {
        if(dp[i][i] == longestCount) {
            endIndex = i
        }
    }

    return if(endIndex == -1) "" else string.substring(endIndex - longestCount, endIndex)
}
