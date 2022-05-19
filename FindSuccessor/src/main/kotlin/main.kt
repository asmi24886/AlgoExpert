fun main(args: Array<String>) {
    println("Hello World!")
}

open class BinaryTree(value: Int) {
    var value = value
    var left: BinaryTree? = null
    var right: BinaryTree? = null
    var parent: BinaryTree? = null
}

//CAN ALSO BE DONE BY INORDER FILL IN A QUEUE AND THEN TAKING OUT AND COMPARING (Bad method)
fun findSuccessor(tree: BinaryTree, node: BinaryTree): BinaryTree? {
    return if(node.right == null) {
        findGrandparentWithLeftParent(node)
    }
    else {
        findLeftMostChild(node.right!!)
    }
}

fun findLeftMostChild(node: BinaryTree): BinaryTree? {
    return if(node.left == null) {
        node
    }
    else {
        findLeftMostChild(node.left!!)
    }
}

fun findGrandparentWithLeftParent(node: BinaryTree): BinaryTree? {

    if(node.parent == null) {
        return null
    }

    return if(node.parent?.left?.value == node.value) {
        node.parent
    }
    else {
        findGrandparentWithLeftParent(node.parent!!)
    }
}