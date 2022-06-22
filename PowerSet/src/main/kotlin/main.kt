fun main(args: Array<String>) {
    println("Hello World!")
}
/*
    1 2 3 4

    [],
    [], [4],
    [], [4], [3], [3, 4],
    [], [4], [3], [3, 4], [2], [2, 4], [2,3], [2, 3, 4]
    [1], [1, 4], [1, 3], [1, 3, 4].....
 */
fun powerset(array: List<Int>): List<List<Int>> {
    if(array.isEmpty()) return listOf(array)

    val powerSets = powerset(array.subList(1, array.size))
    val nextPowerSets = powerSets.map {
        it.toMutableList().apply {
            add(0, array.first())
        }
    }

    return powerSets + nextPowerSets
}
