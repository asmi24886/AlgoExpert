fun main(args: Array<String>) {
    println("Hello World!")
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun findLoop(head: LinkedList?): LinkedList? {
    var sp = head?.next
    var fp = head?.next?.next

    while(fp != sp) {
        fp = fp?.next?.next
        sp = sp?.next
    }

    sp = head

    while(fp != sp) {
        fp = fp?.next
        sp = sp?.next
    }

    return fp
}