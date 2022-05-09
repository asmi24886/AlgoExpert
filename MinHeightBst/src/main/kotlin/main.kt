fun main(args: Array<String>) {
    println("Hello World!")
}

open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int) {
        if (value < this.value) {
            if (this.left == null) {
                this.left = BST(value)
            } else {
                this.left!!.insert(value)
            }
        } else {
            if (this.right == null) {
                this.right = BST(value)
            } else {
                this.right!!.insert(value)
            }
        }
    }
}

fun minHeightBst(array: List<Int>): BST {
    // Write your code here.
    return constructBst(0, array.size-1, null, array)!!
}

fun constructBst(leftIndex: Int, rightIndex: Int,root: BST?,  array: List<Int>) : BST? {

    if(rightIndex < leftIndex) return null

    val middleIndex = ( leftIndex + rightIndex ) / 2
    val _root = root?.also { it.insert(array[middleIndex]) } ?:   BST(array[middleIndex])

    constructBst(leftIndex, middleIndex - 1, _root, array)
    constructBst(middleIndex + 1, rightIndex, _root, array)

    return _root
}