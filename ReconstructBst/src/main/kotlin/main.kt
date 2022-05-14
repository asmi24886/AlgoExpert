fun main(args: Array<String>) {
    println("Hello World!")
}

open class BST(value: Int, left: BST? = null, right: BST? = null) {
    var value = value
    var left = left
    var right = right

    fun insert(_value: Int) {
        if(_value < this.value) {
            if(this.left != null) {
                this.left!!.insert(_value)
            }
            else {
                this.left = BST(_value)
            }
        }
        else {
            if(this.right != null) {
                this.right!!.insert(_value)
            }
            else {
                this.right = BST(_value)
            }
        }
    }
}

fun reconstructBst(preOrderTraversalValues: List<Int>): BST? {

    val root = BST(preOrderTraversalValues.first())
    preOrderTraversalValues.forEachIndexed { index, i ->
        if(index!=0)root.insert(i)
    }
    return root
}