fun main(args: Array<String>) {
    println("Hello World!")
}

fun validIPAddresses(string: String): List<String> {

    if(string.length < 4 || string.length > 12 || string.startsWith("0")) {
        return listOf()
    }

    return listOf()
}

fun String.validateIpPart() =
    this.startsWith("0").not() && this.length <= 3 && this.toInt() <= 255