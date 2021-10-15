package knapsack

class Validator(instance: Instance) {
    val values: List<Int> = instance.values
    val weights: List<Int> = instance.weights
    val capacity: Int = instance.capacity
    val numberOfItems: Int = instance.numberOfItems
    var error: String = ""

    fun isNotValid(): Boolean {
        return !isValid()
    }
    
    fun isValid(): Boolean {
        if (knapsackIsEmpty()) {
            error = "knapsackIsEmpty"
            return false
        }
        if (capacityIsNotValid()) {
            error = "capacityIsNotValid"
            return false
        }
        if (valuesAreNotValid()) {
            error = "valuesAreNotValid"
            return false
        }
        if (weightsAreNotValid()) {
            error = "weightsAreNotValid"
            return false
        }
        return true
    }

    fun knapsackIsEmpty(): Boolean {
        return numberOfItems == 0
    }

    fun capacityIsNotValid(): Boolean {
        return capacity < 0
    }

    fun valuesAreNotValid(): Boolean {
        for (value in values) {
            if (value < 0) {
                return true
            }
        }
        return false
    }

    fun weightsAreNotValid(): Boolean {
        for (weight in weights) {
            if (weight < 0) {
                return true
            }
        }
        return false
    }
}