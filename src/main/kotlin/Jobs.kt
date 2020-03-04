import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            // delay(3000L)
            println("Job1 launched")
            val job2 = launch {
                println("Job2 launch")
                delay(3000L)
                println("Job2 is finishing")
            }
            job2.invokeOnCompletion {
                println("Job2 completed")
            }
            val job3 = launch {
                println("Job3 launch")
                delay(3000L)
                println("Job3 is finishing")
            }
            job3.invokeOnCompletion {
                println("Job3 completed")
            }
        }
        job1.invokeOnCompletion {
            println("Job1 completed")
        }
        delay(500L)
        println("Will be Cancelled")
        job1.cancel()
    }
}