import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
}

fun nodeDepths(root: BinaryTree): Int = measureDepth(root, 0)
fun measureDepth(node: BinaryTree, sum: Int) : Int =
    sum + (node.left?.let {measureDepth(it, sum+1)}?:0) + (node.right?.let {measureDepth(it, sum+1)}?:0)
