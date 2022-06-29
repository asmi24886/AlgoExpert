import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
}

fun nextGreaterElement(array: MutableList<Int>): MutableList<Int> {
    val stack = LinkedList<Int>()
    val resultArray = MutableList(array.size) { -1 }

    for(i in 0 until array.size*2) {
        val currentIndex = i%array.size
        while(stack.isNotEmpty() && array[stack.peek()] < array[currentIndex]) {
            resultArray[stack.peek()] = array[currentIndex]
            stack.pop()
        }
        stack.push(currentIndex)
    }

    return resultArray
}