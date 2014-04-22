package problems
import lib.Mathematics

object problem70 extends App {
  
  val low =  100000
  val up =   999999
  
 val circulars = (low to up).filter( 
		 	i => ( Mathematics.isCircular(i) )
		 )

 println( circulars.sum )

// response 1142856
}