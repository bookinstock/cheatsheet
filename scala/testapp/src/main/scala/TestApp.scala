
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}


object TestApp extends App {
    test_future()

    def test_future() = {
        println("1")

        val a = Future { Thread.sleep(10*1000); 42 }

        val b = a.map(_ * 2)


        a.onComplete {
            case Success(value) => println(s"Got the a callback, value = $value")
            case Failure(e) => e.printStackTrace
        }

        b.onComplete {
            case Success(value) => println(s"Got the b callback, value = $value")
            case Failure(e) => e.printStackTrace
        }


        println("2")
    }

        

}



