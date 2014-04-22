package problems

import lib.Mathematics
import scala.util.control.Breaks


object problem47 extends App {

  val setA = Set[Int](2, 7)
  val setB = Set[Int](3, 5, 7)
  println( setA.diff(setB))
  
  println( Mathematics.getPrimeFactors( 14 ) )
  
  var counter = BigInt(10)

  val Outer = new Breaks
  Outer.breakable {
    while (true) {
      val previous = Mathematics.getPrimeFactors( counter-1 ).toSet
      val current  = Mathematics.getPrimeFactors( counter ).toSet
      val diffLength = current.diff(previous).size
      if ( diffLength  >= 3) {
        Outer.break;
      }
      counter += 1
    }
  }
  println( counter -1 )
  println( Mathematics.getPrimeFactors( 29 ).toSet )
  println( Mathematics.getPrimeFactors( 30 ).toSet )
  println( Mathematics.getPrimeFactors( 31 ).toSet )
  // response
}