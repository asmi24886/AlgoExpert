fun main(args: Array<String>) {
    println("Hello World!")
}
//AAAAAAAAAAAAABBCCCCDD

fun runLengthEncoding(string: String): String {
    var result = ""
    var curCount = 0
    string.forEachIndexed {i, char ->
        curCount++
        if(curCount == 9) {
            result+="9${char}"
            curCount = 0
        }

        if(i+1 <= string.lastIndex && string[i] != string[i+1] && curCount!=0) {
            result+="$curCount$char"
            curCount = 0
        }
        else if(i == string.lastIndex && curCount!=0) {
            result+="$curCount$char"
        }
    }

    return result
}