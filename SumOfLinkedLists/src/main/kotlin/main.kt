fun main(args: Array<String>) {
    println("Hello World!")
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun sumOfLinkedLists(linkedListOne: LinkedList, linkedListTwo: LinkedList): LinkedList {
    var head: LinkedList? = null
    var curr: LinkedList? = null
    var carry = 0

    var node1: LinkedList? = linkedListOne
    var node2: LinkedList? = linkedListTwo

    while(node1 != null || node2 != null) {
        val val1 = node1?.let{it.value}?:0
        val val2 = node2?.let{it.value}?:0
        val total = val1+val2+carry

        val sum = total%10
        carry = if(total > 9) { 1 } else { 0 }

        val node = LinkedList(sum)
        if(head == null) {
            head = node
        }
        if(curr == null) {
            curr = head
        }
        else {
            curr.next = node
            curr = curr.next
        }

        node1 = node1?.next
        node2 = node2?.next
    }

    if(carry == 1) {
        curr?.next = LinkedList(carry)
    }

    return head!!
}

fun printList(ll: LinkedList?) {

    var l: LinkedList? = ll
    while(l!=null) {
        println("${l.value} ")
        l = l.next
    }
}