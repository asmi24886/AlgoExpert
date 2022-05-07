fun main(args: Array<String>) {
    println("Hello World!")
}
open class BST(value: Int) {
    var value = value
    var left: BST? = null
    var right: BST? = null

    fun insert(value: Int): BST {
        println(value)
        if(value >= this.value) {
            if(this.right == null) this.right = BST(value)
            else this.right!!.insert(value)
        }
        else {
            if(this.left == null) this.left = BST(value)
            else this.left!!.insert(value)
        }
        return this
    }

    fun contains(value: Int): Boolean {
        if(this.value == value) {
            return true
        }

        if(value >= this.value && this.right != null) {
            return this.right!!.contains(value)
        }

        if(value < this.value && this.left != null) {
            return this.left!!.contains(value)
        }

        return false
    }

    fun remove(value: Int, parent: BST?=null): BST {

        if(value > this.value) {
            this.right?.remove(value, this)
        }
        else if(value < this.value) {
            this.left?.remove(value, this)
        }
        else {
            //value has been found

            //case 1 if the node is a leaf node
            if(this.left == null && this.right == null) {
                parent?.setValue(value, null) //delete the link of the node
            }
            else if(this.left == null) {
                val child =  this.right
                this.value = child!!.value
                this.left = child.left
                this.right = child.right
            }
            else if(this.right == null) {
                val child =  this.left
                this.value = child!!.value
                this.left = child.left
                this.right = child.right
            }
            else {
                //node has both nodes present
                var valueToReplace = findMinLeftFromRight().value
                this.right!!.remove(valueToReplace, this)
                this.value = valueToReplace
            }
        }
        return this
    }

    private fun findMinLeftFromRight(): BST {
        var node = this.right!!
        while(node.left != null) {
            node = node.left!!
        }
        return node
    }

    private fun setValue(matchedValue: Int, nodeToAssign: BST?) {
        if(this.left?.value == matchedValue) {
            this.left = nodeToAssign

        }
        else if(this.right?.value == matchedValue){
            this.right = nodeToAssign
        }
    }
}