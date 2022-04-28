import kotlin.math.abs

fun main(args: Array<String>) {
    println("Hello World!")
}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun findClosestValueInBst(tree: BST, target: Int): Int {

    if(tree.value == target || (tree.value < target && tree.right == null) || (tree.value > target && tree.left == null)) {
        return tree.value
    }

    var nextNode = if(tree.value < target) tree.right!! else tree.left!!
    var closestvalueUntilNow =  findClosestValueInBst(nextNode , target)

    return if(abs(tree.value - target) <= abs(closestvalueUntilNow - target)) tree.value
    else closestvalueUntilNow
}