import kotlin.math.max

fun main(args: Array<String>) {
    println("Hello World!")
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun binaryTreeDiameter(tree: BinaryTree?): Int {
    return computePathAndDiameter(tree).maxDiameter
}

fun computePathAndDiameter(tree: BinaryTree?) : Result {

    if(tree == null) {
        return Result()
    }

    val leftResult = computePathAndDiameter(tree.left)
    val rightResult = computePathAndDiameter(tree.right)

    val longestPathToReturn = max(leftResult.longestPath, rightResult.longestPath) + 1
    val computedDiameter = leftResult.longestPath + rightResult.longestPath
    val maxDiameterUpUntilNow = max(leftResult.maxDiameter, rightResult.maxDiameter)
    val maxDiameter = max(computedDiameter, maxDiameterUpUntilNow)

    return Result(longestPathToReturn, maxDiameter)
}

data class Result (
    var longestPath: Int = 0,
    var maxDiameter: Int = 0

)

/*********************************************************************************************************************/
fun binaryTreeDiameter2(tree: BinaryTree?): Int {
    if(tree == null)
        return 0
    if(tree.left == null && tree.right == null) return 0
    return computePathAndDiameter(tree).maxDiameter
}

fun computePathAndDiameter2(tree: BinaryTree) : Result {

    if (tree.left == null && tree.right == null) {
        return Result(1, 1)
    }

    var leftLength = tree.left?.let {computePathAndDiameter(it)}
    var rightLength = tree.right?.let { computePathAndDiameter(it) }

    if(leftLength == null) {
        rightLength!!
        rightLength.maxDiameter = max(rightLength.maxDiameter, rightLength.longestPath)
        rightLength.longestPath = rightLength.longestPath + 1
        return rightLength!!
    }
    else if(rightLength == null) {
        leftLength!!
        leftLength.maxDiameter = max(leftLength.maxDiameter, leftLength.longestPath)
        leftLength.longestPath = leftLength.longestPath + 1
        return leftLength
    }
    else {
        val maxLength = max(leftLength.longestPath, rightLength.longestPath)

        val diameter = leftLength.longestPath + rightLength.longestPath
        println("${tree.value} $$$$ ${leftLength.longestPath} $$$ ${rightLength.longestPath}")
        var maxDiameter = max(leftLength.maxDiameter, rightLength.maxDiameter)
        maxDiameter = max(maxDiameter, diameter)
        println("${tree.value} -- ${maxDiameter} -- ${maxLength+1}")
        return Result(maxLength+1, maxDiameter)
    }
}