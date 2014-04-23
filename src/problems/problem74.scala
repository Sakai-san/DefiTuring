package problems
import lib.Mathematics

object problem74 extends App {

val (low, up ) =  (1, 4999999)
var (indexHighestLength, highestLength)  = (1, 1 )
(low to up ).foreach( 
		 	i => {
		 	  val currentLength = Mathematics.chainFactorial(i).length
		 	  if(currentLength > highestLength){
		 		  indexHighestLength =i
		 		  highestLength = currentLength
		 	  }
		 	}
		 )
println ( indexHighestLength )

// response 1233466
}