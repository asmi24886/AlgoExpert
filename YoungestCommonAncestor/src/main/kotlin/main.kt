fun main(args: Array<String>) {
    println("Hello World!")
}

class AncestralTree(name: Char) {
    val name = name
    var ancestor: AncestralTree? = null
}

fun getYoungestCommonAncestor(topAncestor: AncestralTree, descendantOne: AncestralTree, descendantTwo: AncestralTree): AncestralTree? {

    if(descendantOne.name == descendantTwo.name) return descendantOne

    val depth1 = depth(topAncestor, descendantOne)
    val depth2 = depth(topAncestor, descendantTwo)

    return if(depth1 > depth2) {
        backtrackToCommonAncestor(descendantOne, descendantTwo, depth1 - depth2)
    }
    else {
        backtrackToCommonAncestor(descendantTwo, descendantOne, depth2 - depth1)
    }
}

fun backtrackToCommonAncestor(lowerNode: AncestralTree, higherNode: AncestralTree, differenceInDepth: Int) : AncestralTree? {

    var ln:AncestralTree = lowerNode
    var hn:AncestralTree = higherNode
    var depth = differenceInDepth
    while(depth!=0) {
        ln = ln.ancestor!!
        depth--
    }

    while (ln != hn) {
        ln = ln.ancestor!!
        hn = hn.ancestor!!
    }

    return ln
}

fun depth(topAncestor: AncestralTree, descendantOne: AncestralTree): Int {

    var depth = 0
    var currentDescendant: AncestralTree? = descendantOne

    while(currentDescendant != null && currentDescendant != topAncestor) {
        depth++
        currentDescendant = currentDescendant.ancestor
    }

    return depth
}

fun getYoungestCommonAncestorAlternate(topAncestor: AncestralTree, descendantOne: AncestralTree, descendantTwo: AncestralTree): AncestralTree? {

    val hasVisited = mutableMapOf<Char, Boolean>()

    var i: AncestralTree? = descendantOne
    var j: AncestralTree? = descendantTwo

    while(i!=null || j!= null) {
        i?.let {
            if(hasVisited[i!!.name] == true) {
                return i
            }
            hasVisited[i!!.name] = true
            i = i!!.ancestor
        }

        j?.let {
            if(hasVisited[j!!.name] == true) {
                return j
            }
            hasVisited[j!!.name] = true
            j = j!!.ancestor
        }
    }

    return null
}