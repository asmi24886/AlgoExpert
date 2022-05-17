fun main(args: Array<String>) {
    println("Hello World!")
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun invertBinaryTree(tree: BinaryTree) {
    val tempNode = tree.left
    tree.left = tree.right
    tree.right = tempNode
    tree.left?.let { invertBinaryTree(it) }
    tree.right?.let { invertBinaryTree(it) }
}