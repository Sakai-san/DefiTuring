package problems

import lib.Mathematics
import scala.collection.mutable.HashMap
import scala.collection.immutable.SortedMap

object problem66 extends App {

  val low =  2
  val up =  5000 -1
  val totients = HashMap[Int, BigInt]()
  (low to up).foreach( 
		  i => totients.update(i, Mathematics.phiEulerTotient(i) )
  )

  
  println ( 9 *37)
  
 
  println( totients )
  
  // exchange key => value to value => key
  val revert = totients map { _.swap }

  // sort by key (key is now the size and the value is the perimeter
  val phiToN = SortedMap(revert.toSeq: _*)

  println(phiToN)
  
  // get the p whom there are the most triple
  println(phiToN.toList.reverse.head._2)
  // response 9240
  
  // 40/2 different triples p=9240. The more the triangle big is the more triple it could have
  println( phiToN.toList.reverse.head._1 )
  
  
// val uperPrime = all_primes.last
// println( uperPrime )

/*(low to up).foreach( 
		 	i => println( BigDecimal( 1.0)./(i) )
		 )
*/
// response 
}