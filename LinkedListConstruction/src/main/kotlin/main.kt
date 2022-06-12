fun main(args: Array<String>) {
    println("Hello World!")
}

class DoublyLinkedList {
    private var head: Node? = null
    private var tail: Node? = null

    fun getHead() = this.head
    fun getTail() = this.tail

    fun setHead(node: Node) {
        if (head == null) {
            head = node
            tail = node
            return
        }
        insertBefore(head!!, node)
    }

    fun setTail(node: Node) {
        if (tail == null) {
            setHead(node)
            return
        }
        insertAfter(tail!!, node)
    }

    fun insertBefore(node: Node, nodeToInsert: Node) {
        if (nodeToInsert == head && nodeToInsert == tail) {
            return
        }
        remove(nodeToInsert)
        nodeToInsert.prev = node.prev
        nodeToInsert.next = node
        if (node.prev == null) {
            head = nodeToInsert
        } else {
            node.prev!!.next = nodeToInsert
        }
        node.prev = nodeToInsert
    }

    fun insertAfter(node: Node, nodeToInsert: Node) {
        if (nodeToInsert === head && nodeToInsert === tail) {
            return
        }
        remove(nodeToInsert)
        nodeToInsert.prev = node
        nodeToInsert.next = node.next
        if (node.next == null) {
            tail = nodeToInsert
        } else {
            node.next!!.prev = nodeToInsert
        }
        node.next = nodeToInsert
    }

    fun insertAtPosition(position: Int, nodeToInsert: Node) {
        if (position == 1) {
            setHead(nodeToInsert)
            return
        }
        var temp = head
        var pos = 1
        while (temp != null && pos++ != position) {
            temp = temp.next
        }
        if (temp != null) {
            insertBefore(temp, nodeToInsert)
        } else {
            setTail(nodeToInsert)
        }
    }

    fun removeNodesWithValue(value: Int) {
        var temp = head
        while (temp != null) {
            val nodeToRemove: Node = temp
            temp = temp.next
            if (nodeToRemove.value == value) {
                remove(nodeToRemove)
            }
        }
    }

    fun remove(node: Node) {
        if (node == head) {
            head = head!!.next
        }
        if (node == tail) {
            tail = tail!!.prev
        }
        removeNode(node)
    }

    fun containsNodeWithValue(value: Int): Boolean {
        var temp = head
        while (temp != null) {
            if (temp.value == value) {
                return true
            }
            temp = temp.next
        }
        return false
    }

    private fun removeNode(node: Node) {
        if (node.prev != null) {
            node.prev!!.next = node.next
        }
        if (node.next != null) {
            node.next!!.prev = node.prev
        }
        node.prev = null
        node.next = null
    }
}

class Node(value: Int) {
    val value = value
    var prev: Node? = null
    var next: Node? = null
}