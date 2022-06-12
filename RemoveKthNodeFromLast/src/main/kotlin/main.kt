fun main(args: Array<String>) {
    println("Hello World!")
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun removeKthNodeFromEnd(head: LinkedList, k: Int) {
    var first = head
    var second: LinkedList? = head

    for(i in 1..k) {
        second = second!!.next
    }

    if(second == null) {
        head.value = head.next!!.value
        head.next = head.next!!.next
        return
    }

    while(second!!.next != null) {
        first = first.next!!
        second = second.next!!
    }

    first.next = first.next!!.next
}

fun removeKthNodeFromEndAlternate(head: LinkedList, k: Int) {
    val totalCount = findAndRemove(head, k)
    if(totalCount == k) {
        head.value = head.next!!.value
        remove(head)
    }
}

fun findAndRemove(node: LinkedList?, k: Int) : Int {
    if(node == null) {
        return 0
    }

    val count = findAndRemove(node.next, k)

    if(count == k) {
        remove(node)
    }

    return count+1
}

fun remove(node: LinkedList) {
    node.next = node.next!!.next
}
