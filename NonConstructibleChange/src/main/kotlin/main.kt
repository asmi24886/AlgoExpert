fun main(args: Array<String>) {
    println("Hello World!")
}

fun nonConstructibleChange(coins: MutableList<Int>): Int {
    coins.sort()

    var canMakeChangeUpto = 0

    for(coin in coins) {
        if(coin > canMakeChangeUpto+1) return canMakeChangeUpto+1
        else canMakeChangeUpto+=coin
    }
    return canMakeChangeUpto+1
}
