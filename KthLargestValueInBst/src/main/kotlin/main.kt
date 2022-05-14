fun main(args: Array<String>) {
    println("Hello World!")
}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun findKthLargestValueInBst(tree: BST, k: Int): Int {
    return traverseAndFind(tree, k, mutableMapOf(0 to Int.MAX_VALUE, 1 to 0))[0]!!
}

//Can also be done with an inorder traversal and then counting from reverse
fun traverseAndFind(tree: BST, k: Int, result: MutableMap<Int, Int>) : MutableMap<Int, Int> {
    if(result[1] == k) {
        return result
    }
    if(tree.right != null) {
        traverseAndFind(tree.right!!, k, result)
    }

    if(result[1] == k) {
        return result
    }

    if(result[0]!! >= tree.value) {
        result[1] = result[1]!! + 1
        result[0] = tree.value
    }
    if(result[1] == k) {
        return result
    }
    if(tree.left != null) {
        traverseAndFind(tree.left!!, k, result)
    }

    return result
}
