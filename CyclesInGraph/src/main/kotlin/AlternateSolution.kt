import java.util.*

fun cycleInGraph2(edges: List<List<Int>>): Boolean {

    val startNode = findStartingNode(edges) ?: return false

    return traverseAndCheckCycle2(startNode, edges, Stack())
}

fun findStartingNode(edges: List<List<Int>>): Int? {

    for(i in edges.indices) {
        if(edges[i].isNotEmpty()) {
            return i
        }
    }

    return null
}

fun traverseAndCheckCycle2(node: Int, edges: List<List<Int>>, visitedNodes: Stack<Int>): Boolean {

    val children = edges[node]

    if(visitedNodes.contains(node)) {
        return true
    }

    visitedNodes.push(node)

    var hasCycle = false
    for(j in children.indices) {
        hasCycle = hasCycle || traverseAndCheckCycle2(children[j], edges, visitedNodes)
    }

    visitedNodes.pop()

    return hasCycle
}