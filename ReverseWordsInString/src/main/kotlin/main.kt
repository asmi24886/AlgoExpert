fun main(args: Array<String>) {
    println("Hello World!")
}

fun reverseWordsInString(string: String): String {
    var finalString = ""
    var tempString = ""
    for(i in (string.length-1)..0) {
        if(string[i].isWhitespace()) {
            finalString += if(tempString.isEmpty().not()) "$tempString " else " "
            tempString = ""
            continue
        }
        tempString = "${string[i]}$tempString"
    }

    if(tempString.isEmpty().not()) {
        finalString+=tempString
    }

    return finalString
}
