fun main(args: Array<String>) {
    println("Hello World!")
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun reverseLinkedList(head: LinkedList): LinkedList {
    var curNode: LinkedList? = head
    var lastReveredNode: LinkedList? = null

    while(curNode != null) {
        var nextNode = curNode.next
        curNode.next = lastReveredNode

        lastReveredNode = curNode
        curNode = nextNode
    }

    return lastReveredNode!!
}

fun reverseLinkedList2(head: LinkedList): LinkedList {
    return reverseNext(head).first
}

fun reverseNext(node: LinkedList): Pair<LinkedList, LinkedList> {
    if(node.next == null) {
        return Pair(node, node)
    }

    val result = reverseNext(node.next!!)
    val childNode = result.second

    childNode.next = node
    node.next = null

    return Pair(result.first, node)
}