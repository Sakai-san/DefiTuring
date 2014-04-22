package problems
import lib.Mathematics

object problem35 extends App {

  def allPrimes( perm :List[BigInt] ) :Boolean = {
    perm.forall( i=> Mathematics.isPrime(i)  )
  }
 

// take 2 as first circular prime into consideration
// subtility : permutations of 101 are ( 010, 001, 101). Then of course for beeing a circular prime the tested number should not have a 0 as a digit 

  println(  ( BigInt(3) to BigInt(99999) by 2 ).filter( k=> !k.toString.contains("0") && allPrimes( Mathematics.circlePermutations(k) )  ).length +1 )
// response 43
}