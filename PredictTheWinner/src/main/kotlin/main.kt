import kotlin.math.min

fun main(args: Array<String>) {
    println("Hello World!")
    PredictTheWinner(listOf(1,3,1).toIntArray()).also { println(it) }
}

fun PredictTheWinner(nums: IntArray): Boolean {
    val mTable = MutableList(nums.size){ MutableList(nums.size) {-1} }
    val totalPoints = nums.sum()
    val player1Score =  nextTurn(0, nums.size-1, nums, mTable)
    val player2Score = totalPoints - player1Score

    return player1Score >= player2Score
}

fun nextTurn(startIndex: Int, endIndex: Int, nums: IntArray, mTable: MutableList<MutableList<Int>>) : Int {

    /*
        Gametheory minmax:

        max of the minimums will be my chance to win -

        player 2 tries to minimize my profit after i take left(
            left + player 2 takes next left
            left + player 2 takes right
        )

        player 2 tries to minimize my profit after i take right (
            right + player 2 takes left
            right + player 2 takes right
        )

     */
    if(startIndex == endIndex) {
        return nums[startIndex]
    }

    if(startIndex>endIndex) {
        return 0
    }

    if(mTable[startIndex][endIndex] != -1) {
        return mTable[startIndex][endIndex]
    }

    mTable[startIndex][endIndex] = listOf(
        min(nums[startIndex] + nextTurn(startIndex+2, endIndex, nums, mTable),
        nums[startIndex] + nextTurn(startIndex+1, endIndex-1, nums, mTable)),
        min(nums[endIndex] + nextTurn(startIndex+1, endIndex - 1, nums, mTable),
        nums[endIndex] + nextTurn(startIndex, endIndex - 2, nums, mTable))
    ).sorted().last()

    return mTable[startIndex][endIndex]
}