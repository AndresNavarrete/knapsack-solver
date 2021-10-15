package knapsack

fun main() {
    val parser = Parser()
    val input = parser.parseInput("/input.json")
    val instance = createInstance(input)
    val response = solveInstance(instance)
    val jsonOutput = parser.parseOutput(response)
    println(jsonOutput)
}

fun createInstance(input: Map<String, Any>): Instance {
    @Suppress("UNCHECKED_CAST")
    val weights: List<Int> = input.getValue("weights") as List<Int>
    @Suppress("UNCHECKED_CAST")
    val values: List<Int> = input.getValue("values") as List<Int>
    val capacity = input.getValue("capacity") as Number
    return Instance(values, weights, capacity.toInt())
}

fun solveInstance(instance: Instance): Map<String, Any> {
    val algorithm = Algorithm()
    return algorithm.solve(instance)
}
