package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem69 extends App {
  
   
  /*
   * phhi function say how many number p (p<n), are coprime with n
   * example : phi( 10 ) = |{ (1,10), (3,10), (7,10), (9,10) }| = 4
   * 
   * other formula to compute n (see wikipedia), p|n "means if primes divide n"
   * phi(n) = n IIp|n( 1 - 1/p ) 
   * example :
   * phi ( 7 ) = 7 * ( 1-1/7) = 7*(6/7) = 6 
   * phi ( 10 ) = 10*( (1/2) * (4/5)  ) = 5 *(4/5) = 4
   * 
   * In our case we have to maximize : n/phi(n) = n/(n IIp|n (1 - 1/p)) = 1 / IIp|n (1 - 1/p)
   * then we have to minimize the denominator, which means the number with at most prime factors
   */
  
	var all_primes = List(2 ) ::: ( 3 to 5000 by 2 ).filter( i => Mathematics.isPrime( i ) ).toList
    var primeMultiple = 1
	var i = 0
	val limit = 1000000

	while( primeMultiple* all_primes.head < limit){
	    primeMultiple *= all_primes.head
	    all_primes = all_primes.tail
	}

  println( primeMultiple )
  
  // response 510510
}