package knapsack

class Instance(val values: List<Int>, val weights: List<Int>, val capacity: Int) {
    val numberOfItems: Int = values.size
}
