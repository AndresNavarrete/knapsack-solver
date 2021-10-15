package knapsack

import kotlin.math.max

class Algorithm {

    var weights: List<Int> = listOf()
    var values: List<Int> = listOf()
    var capacity: Int = 0
    var numberOfItems: Int = 0
    var valueToGo: Array<IntArray> = Array(0) { IntArray(0) }
    var optimalValue: Int = 0
    val itemsSelected: MutableList<Int> = mutableListOf()

    fun solve(instance: Instance): Map<String, Any> {
        initialize(instance)
        executeAlgorithm()
        reportResults()
        return mapOf("status" to "ok", "optimal_solution" to itemsSelected , "optimal_value" to optimalValue)

    }

    fun initialize(instance: Instance) {
        weights = instance.weights
        values = instance.values
        capacity = instance.capacity
        numberOfItems = instance.numberOfItems
        valueToGo = Array(numberOfItems + 1) { IntArray(capacity + 1) {0} }

    }   

    fun executeAlgorithm() {
        for (item in 1..numberOfItems) {
            for (currentCapacity in 1..capacity) {
                updateValueToGo(item, currentCapacity)
            }
        }
    }

    fun updateValueToGo(item: Int, currentCapacity: Int) {
        if (weights[item - 1] > currentCapacity ) {
            return
        }
        val currentValueToGo: Int = valueToGo[item - 1][currentCapacity]
        val remainingCapacity: Int = currentCapacity - weights[item - 1]
        val candidateValueToGo: Int = valueToGo[item - 1][remainingCapacity] + values[item - 1]
        valueToGo[item][currentCapacity] = max(currentValueToGo, candidateValueToGo)
    }

    fun reportResults() {
        optimalValue = getMaxValue()
        getSelectedItems()
    }

    fun getMaxValue(): Int {
        return valueToGo[numberOfItems][capacity]
    }

    fun getSelectedItems() {
        var currentCapacity: Int = capacity
        var valueWithObject: Int
        var valueWithoutObject: Int
        var itemSelected: Int
        for (item in numberOfItems downTo 1) {
            valueWithObject = valueToGo[item][currentCapacity]
            valueWithoutObject = valueToGo[item - 1][currentCapacity]
            if (valueWithObject <= valueWithoutObject) {
              continue  
            }
            itemSelected = item - 1
            itemsSelected.add(itemSelected)
            currentCapacity -= weights[itemSelected]
        }
        itemsSelected.sort()
    }

}
