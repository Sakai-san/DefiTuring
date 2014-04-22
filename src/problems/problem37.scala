package problems

import scala.util.control.Breaks

import lib.Mathematics

object problem37 extends App {

  def allTruncPrime(limit: Int) = {
    var counter = 0
    var current = BigInt(9)
    var truncPrime = List[BigInt]()

    val Outer = new Breaks
    Outer.breakable {
      while (true) {
        val currentIsPrimeTrunc = Mathematics.isPrimeTrunc(current)
        if (currentIsPrimeTrunc) {
          truncPrime = truncPrime ::: List(current)
          counter += 1
        }

        if (counter >= limit) {
          Outer.break;
        }
        // even number are not to be considerated
        current += 2
      }
    }
    truncPrime
  }
  
  var allTruncPrimes = allTruncPrime(11)
  println( "all trunc primes : " + allTruncPrimes )
  println( "sum of all trunc primes : " + allTruncPrimes.sum)

  // response 748317
}