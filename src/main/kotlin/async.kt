import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val firstDeferred = async { getFirstValue() }
        val secondDeferred = async { getSecondValue() }
        println("Processing")
        delay(500L)
        println("waitting")
        val firstValue = firstDeferred.await()
        val SecondValue = secondDeferred.await()
        println("The total is ${firstValue + SecondValue}")
    }
}
suspend fun getFirstValue(): Int {
    delay(100L)
    val value = Random.nextInt(100)
    println("Returning first value $value")
    return value;
}
suspend fun getSecondValue(): Int {
    delay(200L)
    val value = Random.nextInt(1000)
    println("Returning second value $value")
    return value;
}