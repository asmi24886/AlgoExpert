fun main(args: Array<String>) {
    println("Hello World!")
}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null
}

fun validateBst(tree: BST): Boolean {
    return validate(tree, Int.MIN_VALUE, Int.MAX_VALUE)
}

fun validate(tree: BST?, min: Int, max: Int): Boolean {
    if(tree == null) return true
    if(tree.value < min || tree.value >= max) return false
    return validate(tree.left, min, tree.value) && validate(tree.right, tree.value, max)
}