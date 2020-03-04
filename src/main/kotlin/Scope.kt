import kotlinx.coroutines.*
fun main() {
    println("Start")
    runBlocking {
        launch {
            delay(1000L)
            println("Task runBlocking")
        }
        GlobalScope.launch {
            delay(500L)
            println("Task GlobalScope")
        }
        coroutineScope {
            launch {
                delay(1500L)
                println("Task coroutineScope")
            }
        }
    }
    println("End")
}