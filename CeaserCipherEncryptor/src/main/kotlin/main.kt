fun main(args: Array<String>) {
    println(caesarCipherEncryptor("xyz", 28))
}

fun caesarCipherEncryptor(string: String, key: Int): String {

    return string.map {
       (97 + ((it - 97) + key%26).toInt() % 26).toChar()
    }.joinToString("")

}