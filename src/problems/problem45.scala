package problems
import lib.Mathematics
import scala.util.control.Breaks

object problem45 extends App {

 var counter = BigInt(40756)
  
  val Outer = new Breaks
  Outer.breakable {
    while (true) {
      if (
          Mathematics.triangularInverse(counter) !=0 
          && Mathematics.pantagonalInverse(counter) !=0
          && Mathematics.hexagonalInverse(counter) !=0
         ){
        Outer.break;
      }
      counter += 1
    }
  }
   println( counter )

// response 1533776805
}