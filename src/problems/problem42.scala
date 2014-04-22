package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem42 extends App {
  
 ( 10 to 99 ).foreach( 
						i =>{
						  val rigthHandSide = i * ( i + 1 ) 
						  val iString = i.toString
						   if(
						     iString.substring(0,1) != iString.substring(1,2)
						     && rigthHandSide.toString.length() == 4
						     && rigthHandSide.toString.toList.distinct.length == 4
						     && rigthHandSide.toString.substring(2,3).contains( iString.charAt(0) ) // rigth-hand side does contains "U"
						     
						     && ! iString.contains( rigthHandSide.toString.charAt(0) ) // i does not contains "D"
						     && ! iString.contains( rigthHandSide.toString.charAt(1) ) // i does not contains "E"
						     && ! iString.contains( rigthHandSide.toString.charAt(3) ) // i does not contains "X"
						    )
						     println( rigthHandSide )
			})

 // response 7482

}