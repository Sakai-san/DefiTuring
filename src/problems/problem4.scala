package problems
import lib.Mathematics

object problem4 extends App{

val (aMin, aMax, bMin, bMax ) = (1, 9999, 1, 999)
  

val palindromes =  (aMax to aMin by -1).flatMap(i => (bMax to bMin by -1).map(
										j => {i * j}
		  										).filter( {k => Mathematics.isPalindrome( k.toString)})
		  				)

println( palindromes.max )
  // response 9744479
}