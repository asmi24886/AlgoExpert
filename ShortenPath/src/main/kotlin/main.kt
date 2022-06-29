import java.util.*

fun main(args: Array<String>) {
    shortenPath("./..").also { println(it) }
}

fun shortenPath(path: String): String {
    val stack = LinkedList<String>()
    val isRelative = path.startsWith("/").not()

    var startIndex = 0
    var prefix = LinkedList<String>()

    val paths = path.split("/").filter{ it != "." && it != ""}

    if(paths.isEmpty()) {
        if(isRelative) {
            return ""
        }
        else {
            return "/"
        }
    }

    while(startIndex != paths.size && paths[startIndex] == "..") {
        if(isRelative) {
            prefix.push("..")
        }
        startIndex++
    }

    for(index in startIndex until paths.size) {

        if(paths[index] == "..") {
            if(stack.isNotEmpty())
                stack.pop()
            else {
                if(isRelative) {
                    prefix.push("..")
                }
            }
        }
        else {
            stack.push(paths[index])
        }
    }
    prefix.addAll(stack.reversed())
    return prefix.joinToString("/").let {
        if(isRelative) it else "/$it"
    }
}