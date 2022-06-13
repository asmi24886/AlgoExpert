fun main(args: Array<String>) {
    println("Hello World!")
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun shiftLinkedList(head: LinkedList, k: Int): LinkedList {
    var size = getLength(head)
    var shiftCount = k%size
    if(shiftCount < 0) shiftCount += size
    if(shiftCount == 0) return head

    var traverseCount = 1
    var node = head

    while(traverseCount < size - shiftCount) {
        node = node.next!!
        traverseCount++
    }

    var newHead = node.next!!
    node.next = null

    node = newHead
    while(node.next != null) {
        node = node.next!!
    }

    node.next = head

    return newHead
}

fun getLength(head: LinkedList): Int {
    var counter = 1
    var node: LinkedList = head

    while(node.next != null) {
        node = node.next!!
        counter++
    }

    return counter
}