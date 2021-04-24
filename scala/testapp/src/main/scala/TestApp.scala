
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


object TestApp extends App {
    test_future()



    //

    // future key points:
    // - You construct futures to run tasks off of the main thread
    // - Futures are intended for one-shot, potentially long-running concurrent tasks that eventually return a value
    // - A future starts running as soon as you construct it
    // - A benefit of futures over threads is that they come with a variety of callback methods that simplify the process of working with concurrent threads, including the handling of exceptions and thread management
    // - Handle the result of a future with methods like onComplete, or combinator methods like map, flatMap, filter, andThen, etc.
    // - The value in a Future is always an instance of one of the Try types: Success or Failure
    // - If you’re using multiple futures to yield a single result, you’ll often want to combine them in a for-expression

    def test_future() = {
        // test_future_single()
        test_future_multi()
    }

    def test_future_single() = {
        println("start")

        val a = Future {
            Thread.sleep(5 * 1000)
            3
        }

        val b = a.map(_ * 2)

        val c = b.map(_ * 2)

        println("a=", a)
        println("b=", b)

        println("end")

        a.onComplete {
            case Success(data) => println(f"a success $data")
            case Failure(e)=> e.printStackTrace
        }

        b.onComplete {
            case Success(data) => println(f"b success $data")
            case Failure(e)=> e.printStackTrace
        }

        // conComplete conSuccess onFailure

        // map,flatMap,filter,foreach

        // andThen fallbackTo recoverWith
    }

    def test_future_multi() = {
        // use this to determine the “delta time” below
        val startTime = currentTime

        println("starttime=",startTime)

        // (a) create three futures
        val aaplFuture = getStockPrice("AAPL")
        val amznFuture = getStockPrice("AMZN")
        val googFuture = getStockPrice("GOOG")

        // (b) get a combined result in a for-expression
        val result: Future[(Double, Double, Double)] = for {
            aapl <- aaplFuture
            amzn <- amznFuture
            goog <- googFuture
        } yield (aapl, amzn, goog)

        println("result=",result)

        // (c) do whatever you need to do with the results
        result.onComplete {
            case Success(x) => {
                val totalTime = deltaTime(startTime)
                println(s"In Success case, time delta: ${totalTime}")
                println(s"The stock prices are: $x")
                println("class=", x.getClass())
            }
            case Failure(e) => e.printStackTrace
        }

        // important for a short parallel demo: you need to keep
        // the jvm’s main thread alive
        sleep(5000)



    }

    def sleep(time: Long): Unit = Thread.sleep(time)

    // a simulated web service
    def getStockPrice(stockSymbol: String): Future[Double] = Future {
        val r = scala.util.Random
        val randomSleepTime = r.nextInt(3000)
        println(s"For $stockSymbol, sleep time is $randomSleepTime")
        val randomPrice = r.nextDouble * 1000
        sleep(randomSleepTime)
        randomPrice
    }

    def currentTime = System.currentTimeMillis()
    def deltaTime(t0: Long) = currentTime - t0

        

}





