package knapsack

import com.squareup.moshi.Moshi
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types

class Parser {

    val moshi = Moshi.Builder().build()
    val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(
        Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
    )

    fun parseInput(sourceFilename: String): Map<String, Any> {
        val message = Parser::class.java.getResource(sourceFilename).readText()
        val input: Map<String, Any> = adapter.fromJson(message) as Map<String, Any>
        return input
    }

    fun parseOutput(response: Map<String, Any> ): String {
        val output: String = adapter.toJson(response)
        return output
    }
}
