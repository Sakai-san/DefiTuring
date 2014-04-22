package problems

import lib.Mathematics

object problem10 extends App {

  val start = 3
  val ending = 9999999
  
  var sumPrimes :BigInt = (start to ending by 2).filter( Mathematics.isPrime(_)).sum

  // add the prime number 2
  sumPrimes += 2
  println("sum of primes number : " + sumPrimes)
  

  // response 3203324994356
}