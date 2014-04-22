package problems

import lib.Mathematics
import scala.util.control.Breaks

object problem52 extends App {

  def allFactorsSamePattern( n :BigInt ) :Boolean ={
    Mathematics.hashOfNumber(n) == Mathematics.hashOfNumber( 2 * n) &&
    Mathematics.hashOfNumber(n) == Mathematics.hashOfNumber( 3 * n) && 
    Mathematics.hashOfNumber(n) == Mathematics.hashOfNumber( 4 * n) &&
    Mathematics.hashOfNumber(n) == Mathematics.hashOfNumber( 5 * n) &&
    Mathematics.hashOfNumber(n) == Mathematics.hashOfNumber( 6 * n)  
  }
  
  var counter = BigInt(1)

  val Outer = new Breaks
  Outer.breakable {
    while (true) {
      if ( allFactorsSamePattern( counter ) ){
        Outer.break;
      }
      counter += 1
    }
  }

  println( counter )
// response is 142857
}