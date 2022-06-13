fun main(args: Array<String>) {
    println("Hello World!")
}

open class LinkedList(value: Int) {
    var value = value
    var next: LinkedList? = null
}

fun mergeLinkedLists(headOne: LinkedList, headTwo: LinkedList): LinkedList {

    var p1: LinkedList? = null
    var p2: LinkedList? = headOne

    var p3: LinkedList? = headTwo

    var newHead: LinkedList? = p2


    //The logic is -
    /*
            Treat one linked list as primary and the other as just a data stream
            put a window in the actual linked list p1 -> p2
            point p3 to the stream of data

            peep first from stream and check if its less than p2 because it will be always greater than p1
            if less, insert between p1 n p2.. then move the p1 pointer to the inserted node before p2
            now next data in stream is guaranteed to be equal or greater than p1.

            if data is greater than p2 then move move p1 and p2 together.

            loop breaks if data stream ends or the linked list to put into ends. In this case if p3 is left add on in tail.

     */
    while(true) {
        if(p3 == null) {
            break
        }
        if(p2 == null) {
            p1!!.next = p3
            break
        }

        if(p3.value <= p2.value) {
            val p3Next = p3.next
            p3.next = p2

            if(p1 == null) {
                p1 = p3
                newHead = p1
            }
            else {
                p1.next = p3
                p1 = p1.next
            }

            p3 = p3Next

        }
        else {
            p1 = p2
            p2 = p1.next
        }
    }

    return newHead!!
}