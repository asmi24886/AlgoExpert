import java.lang.Exception

fun main(args: Array<String>) {
    println("Hello World!")
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

data class BalanceFactor(
    var height: Int,
    var balanced: Boolean
)

fun heightBalancedBinaryTree(tree: BinaryTree): Boolean {
    return findHeightBalance(tree).also { println(it) }.balanced
}

fun findHeightBalance(tree: BinaryTree?) : BalanceFactor {
    if(tree == null) {
        return BalanceFactor(0, true)
    }

    val leftResult = findHeightBalance(tree.left)
    val rightResult = findHeightBalance(tree.right)

    val maxHeight = Math.max(leftResult.height, rightResult.height)
    val newBalanceFactor = BalanceFactor(maxHeight+1, false)

    //balancing factor of an AVL tree => height of the left subtree - height of the right subtree
    if(leftResult.balanced && rightResult.balanced &&
            Math.abs(leftResult.height - rightResult.height) <= 1) {
        newBalanceFactor.balanced = true
    }

    return newBalanceFactor
}

