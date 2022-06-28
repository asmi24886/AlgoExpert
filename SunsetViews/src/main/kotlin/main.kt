import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")
}

fun sunsetViews(buildings: List<Int>, direction: String): List<Int> {

    val stack = LinkedList<Int>()

    buildings.forEachIndexed {
        index, currentBuildingHeight ->
        if(stack.isEmpty()) stack.push(index)
        else if(direction == "WEST") {
            val lastBuildingHeight = buildings[stack.peek()]
            if(lastBuildingHeight < currentBuildingHeight) {
                stack.push(index)
            }
        }
        else {
            while(stack.peek() != null && currentBuildingHeight >= buildings[stack.peek()]) {
                stack.pop()
            }
            stack.push(index)
        }
    }

    return stack
}