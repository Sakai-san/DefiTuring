package problems

import lib.Mathematics
import scala.util.control.Breaks

object problem61 extends App {

  var current = BigInt(10)
  var howManyMatch = 0

  val Outer = new Breaks
  Outer.breakable {
    while (true) {
      if ( current % 10 != 0 && !Mathematics.hasIsolatedDigit( current.pow(2)) ) {
       howManyMatch += 1
       if( howManyMatch >= 4 ) Outer.break;
      }
     current += 1
    }

  }

  println("The forth : " + current )
// response 2973962
}