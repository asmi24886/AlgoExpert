fun main(args: Array<String>) {
    println("Hello World!")
}

// This is an input class. Do not edit.
open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun removeDuplicatesFromLinkedList(linkedList: LinkedList): LinkedList {

    var nextNode: LinkedList? = null
    var currentNode: LinkedList? = linkedList

    while(currentNode?.next != null) {
        nextNode = currentNode.next
        while(currentNode.value == nextNode?.value) {
            nextNode = nextNode.next
            currentNode.next = nextNode
        }
        currentNode = nextNode
    }
    return linkedList
}
