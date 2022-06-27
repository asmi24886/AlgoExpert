fun main(args: Array<String>) {
    println("Hello World!")
}

open class MinMaxStack() {
    val list = mutableListOf<Int>()
    val minMaxList = mutableListOf<Pair<Int, Int>>()

    fun peek(): Int? {
        return list.lastOrNull()
    }

    fun pop(): Int? {
        val returnVal = list.lastOrNull()
        return returnVal?.also {
            list.removeAt(list.lastIndex)
            minMaxList.removeAt(minMaxList.lastIndex)
        }
    }

    fun push(number: Int) {
        val minValue = if(list.isEmpty() || minMaxList.last().first > number) number else minMaxList.last().first
        val maxValue = if(list.isEmpty() || minMaxList.last().second < number) number else minMaxList.last().second
        list.add(number)
        minMaxList.add(Pair(minValue, maxValue))
    }

    fun getMin(): Int? {
        return minMaxList.lastOrNull()?.first
    }

    fun getMax(): Int? {
        return minMaxList.lastOrNull()?.second
    }
}