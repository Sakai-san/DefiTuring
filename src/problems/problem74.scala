package problems
import lib.Mathematics

object problem74 extends App {

val (low, up ) =  (1, 4999999)
var (indexHighestLength, highestLength)  = (1, 10000 )
(low to up ).foreach( 
		 	i => {
		 	  val currenLength = Mathematics.chainFactorial(i).length
		 	  indexHighestLength = if (currenLength > highestLength) i else indexHighestLength 
		 	}
		 )
println ( indexHighestLength )

// response
}