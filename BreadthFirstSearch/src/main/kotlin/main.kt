import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
}

class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()

    fun breadthFirstSearch(): List<String> {
        val output = mutableListOf<String>()
        val queue = LinkedList<Node>()

        queue.offer(this)

        while(queue.isNotEmpty()) {
            val currentNode = queue.remove()
            output.add(currentNode.name)
            queue.addAll(currentNode.children)
        }

        return output
    }
}