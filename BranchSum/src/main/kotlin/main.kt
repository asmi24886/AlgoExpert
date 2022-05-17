fun main(args: Array<String>) {
    println("Hello World!")
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun branchSums(root: BinaryTree): List<Int> {
    return currentSum(root)
}

fun currentSum(tree: BinaryTree): MutableList<Int> {

    if(tree.left == null && tree.right == null) {
        return mutableListOf(tree.value)
    }
    val leftSum = tree.left?.let {currentSum(it)}?: mutableListOf()
    val rightSum = tree.right?.let {currentSum(it)}?: mutableListOf()

    leftSum.addAll(rightSum)

    return leftSum.map { it + tree.value }.toMutableList()
}
