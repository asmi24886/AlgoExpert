fun main(args: Array<String>) {
    println("Hello World!")
}

data class Result(
    var maxPathSumAsBranch: Int = 0,
    var maxPathSum: Int = 0
)
open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun maxPathSum(tree: BinaryTree): Int {

    return  maxSumUpUntilNow(tree).maxPathSum
}

fun maxSumUpUntilNow(tree: BinaryTree?) : Result {

    if(tree == null)
        return Result(0, Int.MIN_VALUE)

    val left = maxSumUpUntilNow(tree.left)
    val right = maxSumUpUntilNow(tree.right)

    /*
        1. Find max branch some path from left and right - MBSP
        2. Check which is max - MBSP + value OR value - New MBSP - NMBSP
        3. Check should we take this as root or branch - max of left + right + root AND NMBSP - finalResult
        4. Compare left root path , right root path , finalresult
     */
    val maxBranchPathSum = Math.max(left.maxPathSumAsBranch, right.maxPathSumAsBranch)
    val newMaxBranchPathSum = Math.max(maxBranchPathSum+tree.value , tree.value)

    val finalResult = Math.max(newMaxBranchPathSum, left.maxPathSumAsBranch + right.maxPathSumAsBranch + tree.value)
    val maxPathSum = Math.max(Math.max(left.maxPathSum, right.maxPathSum), finalResult)

    return Result(newMaxBranchPathSum, maxPathSum)

}