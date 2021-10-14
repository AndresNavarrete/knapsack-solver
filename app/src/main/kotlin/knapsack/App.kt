package knapsack

fun main() {
    val loader = Loader("/input.json")
    val instance = createInstance(loader)
}

fun createInstance(loader: Loader): Instance {
    val weights = loader.input.getValue("weights") as List<Int>
    val values = loader.input.getValue("values") as List<Int>
    val capacity = loader.input.getValue("capacity") as Number
    return Instance(values, weights, capacity.toInt())
}
