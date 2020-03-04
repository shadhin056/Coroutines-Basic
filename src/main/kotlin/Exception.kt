import kotlinx.coroutines.*
import java.lang.ArithmeticException
import java.lang.IndexOutOfBoundsException

fun main() {
    runBlocking {
        val myHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
            println("Exception Handled : ${throwable.localizedMessage}")
        }
        val job = GlobalScope.launch(myHandler) {
            println("Throwing exception from job")
            throw IndexOutOfBoundsException("Exception in Coroutine")
        }
        job.join()

        val deferred = GlobalScope.async {
            println("Throwing exception from async")
            throw ArithmeticException("Exception in async")

        }
        try {
            deferred.await()
        } catch (e: ArithmeticException) {
            println("Caught ArithmaticException ${e.localizedMessage}")
        }
    }
}