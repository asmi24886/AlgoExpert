fun main(args: Array<String>) {
    println(MinHeap(mutableListOf(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)))
}

open class MinHeap(array: MutableList<Int>) {
    val heap = this.buildHeap(array)

    fun buildHeap(array: MutableList<Int>): MutableList<Int> {
        val pIndex = parent(array.lastIndex)
        for(i in pIndex downTo 0) {
            siftDown(i, array.lastIndex, array)
        }

        return array
    }

    fun siftDown(currentIdx: Int, endIdx: Int, heap: MutableList<Int>) {
        var _currentIndex = currentIdx
        while(true) {
            if(_currentIndex >= endIdx) {
                break
            }

            val leftIndex = left(_currentIndex)
            val rightIndex = right(_currentIndex)

            if(leftIndex > endIdx) {
                break
            }

            val leftValue = heap[leftIndex]
            val rightValue = if(rightIndex <= endIdx) heap[rightIndex] else null

            val comparisonIndex = if(rightValue == null) leftIndex else if(leftValue <= rightValue) leftIndex else rightIndex

            if(heap[_currentIndex] > heap[comparisonIndex]) {
                swap(_currentIndex, comparisonIndex, heap)
                _currentIndex=comparisonIndex
            }
            else {
                break
            }
        }
    }

    fun siftUp(currentIdx: Int, heap: MutableList<Int>) {
        var _currentIndex = currentIdx
        while(true) {
            if(_currentIndex == 0) {
                break
            }

            val parentIndex = parent(_currentIndex)
            if(heap[_currentIndex] < heap[parentIndex]) {
                swap(parentIndex, _currentIndex, heap)
                _currentIndex=parentIndex
            }
            else {
                break
            }
        }
    }

    fun peek(): Int? {
        return heap.firstOrNull()
    }

    fun remove(): Int? {

        val ret = heap.firstOrNull() ?: return null
        swap(0, heap.lastIndex, heap)
        heap.removeAt(heap.lastIndex)
        siftDown(0, heap.lastIndex, heap)

        return ret
    }

    fun insert(value: Int) {
        heap.add(value)
        siftUp(heap.lastIndex, heap)
    }

    fun parent(value: Int) : Int = (value - 1)/2
    fun left(value: Int) : Int = (value*2)+1
    fun right(value: Int) : Int = (value*2) + 2
    fun swap(i: Int, j: Int, heap: MutableList<Int>) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }
}