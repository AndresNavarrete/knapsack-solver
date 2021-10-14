package knapsack

import com.squareup.moshi.Moshi
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Types


class Loader(filename: String) {

    val message = Loader::class.java.getResource(filename).readText()
    val moshi = Moshi.Builder().build()
    val adapter: JsonAdapter<Map<String, Any>> = moshi.adapter(
        Types.newParameterizedType(Map::class.java, String::class.java, Any::class.java)
    )
    val input: Map<String, Any> = adapter.fromJson(message) as Map<String, Any>

}