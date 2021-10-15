package knapsack

import kotlin.math.max

class Algorithm() {

    var valueToGo: MutableList<Int> = mutableListOf()
    var weights: List<Int> = listOf()
    var values: List<Int> = listOf()
    var capacity: Int = 0
    var numberOfItems: Int = 0

    fun solve(instance: Instance): Int {
        initialize(instance)
        fillValueToGo()
        return getMaxValue()
    }

    fun initialize(instance: Instance) {
        weights = instance.weights
        values = instance.values
        capacity = instance.capacity
        numberOfItems = instance.numberOfItems
        for (i in 0..capacity) {
            valueToGo.add(0)
        }
    }   

    fun fillValueToGo() {
        for (item in 0..numberOfItems - 1) {
            for (currentCapacity in capacity downTo 0) {
                updateValueToGo(item, currentCapacity)
            }
        }
    }

    fun updateValueToGo(item: Int, currentCapacity: Int) {
        if (weights[item] > currentCapacity) {
            return
        }
        val currentValueToGo: Int = valueToGo[currentCapacity]
        val remainingWeight: Int = currentCapacity - weights[item]
        val candidateValueToGo: Int = valueToGo[remainingWeight] + values[item]
        valueToGo[currentCapacity] = max(currentValueToGo, candidateValueToGo)
    }

    fun getMaxValue(): Int {
        return valueToGo[capacity]
    }
}
