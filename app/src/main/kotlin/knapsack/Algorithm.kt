package knapsack

import kotlin.math.max

class Algorithm() {

    var valueToGo: MutableList<Int> = mutableListOf()
    var weights: List<Int> = listOf()
    var values: List<Int> = listOf()
    var capacity: Int = 0
    var numberOfItems: Int = 0

    fun solve(instance: Instance) {
        initialize(instance)
        fillValueToGo()
        println(getMaxValue())
    }

    fun initialize(instance: Instance) {
        weights = instance.weights
        values = instance.values
        capacity = instance.capacity
        numberOfItems = instance.numberOfItems
        for (i in 0..capacity + 1) {
            valueToGo.add(0)
        }
    }   

    fun fillValueToGo() {
        for (item in 0..numberOfItems) {
            for (currentWeight in capacity downTo 0) {
                updateValueToGo(item, currentWeight)
            }
        }
    }

    fun updateValueToGo(item: Int, currentWeight: Int) {
        if (weights[item] > currentWeight) {
            return
        }
        val currentValueToGo: Int = valueToGo[currentWeight]
        val remainingWeight: Int = currentWeight - weights[item]
        val candidateValueToGo: Int = valueToGo[remainingWeight] + values[item]
        valueToGo[currentWeight] = max(currentValueToGo, candidateValueToGo)
    }
    fun getMaxValue(): Int {
        return valueToGo[capacity]
    }
}