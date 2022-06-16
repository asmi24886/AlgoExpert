fun main(args: Array<String>) {
    println("Hello World!")
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun linkedListPalindrome(head: LinkedList?): Boolean {
    if(head?.next == null) return true
    return isThisNodePalindrome(head, head.next!!) != null
}

fun isThisNodePalindrome(head: LinkedList, node: LinkedList) : LinkedList? {

    //This is the last node
    if(node.next == null) {
        if(node!!.value == head.value) {
            return head.next
        }
        return null
    }

    val nextHeadToCompare = isThisNodePalindrome(head, node.next!!) ?: return null

    if(nextHeadToCompare.value == node.value) {
        return nextHeadToCompare.next
    }

    return null
}