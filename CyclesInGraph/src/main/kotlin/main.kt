fun cycleInGraph(edges: List<List<Int>>): Boolean {

    val totalNodes = edges.size
    val ancestorStack = MutableList(totalNodes) {false} //took this idea from algo expert. very clever
    val nodesCheckedForCycleList = MutableList(totalNodes) {false}

    for(i in 0 until totalNodes) {
        if(nodesCheckedForCycleList[i].not()) {
            val hasCycle = traverseAndFindCycle(i, edges, ancestorStack, nodesCheckedForCycleList)
            if(hasCycle) {
                return true
            }
        }
    }

    return false
}

fun traverseAndFindCycle(
    node: Int,
    edges: List<List<Int>>,
    ancestorStack: MutableList<Boolean>,
    nodesCheckedForCycleList: MutableList<Boolean> ) : Boolean {

    if(ancestorStack[node]) {
        return true
    }

    ancestorStack[node] = true
    val children = edges[node]

    var hasCycle = false
    for(childNode in children) {

        if(nodesCheckedForCycleList[childNode].not()) {
            hasCycle = hasCycle || traverseAndFindCycle(childNode, edges, ancestorStack, nodesCheckedForCycleList)
        }
    }
    ancestorStack[node] = false //remove from stack
    nodesCheckedForCycleList[node] = true
    return hasCycle
}