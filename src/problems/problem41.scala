package problems

import lib.Mathematics
import scala.util.control.Breaks

object problem41 extends App {

 val up = BigInt(999999999)

  var counter = up

    val Outer = new Breaks
    Outer.breakable {
      while (true) {
        if (   Mathematics.isPandigital(counter) && Mathematics.isPrime(counter)  ) {
          Outer.break;
        }

        // even number are not to be considerated
        counter -= 2
       
      }
    }

println(counter)
// response is 7652413
}