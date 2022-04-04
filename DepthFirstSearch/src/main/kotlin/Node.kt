class Node(name: String) {
    val name: String = name
    val children = mutableListOf<Node>()
    fun depthFirstSearch() = traverse(mutableListOf(), mutableMapOf())

    private fun traverse(
        output: MutableList<String>,
        visited: MutableMap<String, Boolean>
    ): MutableList<String> {

        if(visited[name] == true) {
            return output
        }

        visited[name] = true
        output.add(name)

        children.forEach {
            it.traverse(output, visited)
        }

        return output
    }
}