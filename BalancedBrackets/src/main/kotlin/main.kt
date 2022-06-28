import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
}

fun balancedBrackets(str: String): Boolean {
    val stack = LinkedList<Char>()
    val counterBrackets = mapOf(')' to '(', '}' to '{', ']' to '[')
    str.forEach {
        if(it in counterBrackets.keys) {
            if(stack.peek() != counterBrackets[it]) {
                return false
            }
            stack.pop()
        }
        else {
            if(it in counterBrackets.values) stack.push(it)
        }
    }
    return stack.isEmpty()
}
