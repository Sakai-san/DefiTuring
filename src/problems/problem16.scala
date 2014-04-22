package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem16 extends App {
  
  /*
   * Algorithm
   * compute two set (equation right and left hand-side)
   * store the result in a hash : product -> List( a + "" + b, ...)
   * store the result in a hash : product -> List( c + "" + d, ...)
   * compare both string list (within the hashes) by same product (key)
   * with the constraints, namely a(0) == c(0), etc...
   */
  
val combination1 = HashMap[Int, List[String]]()
val combination2 = HashMap[Int, List[String]]()

 ( 99999 to 10000 by -9 ).foreach( 
				i => { (9999 to  1000 by -3).foreach(
								j =>{
								  val product = i * j
								  val iString = i.toString
								  val jString = j.toString
								   if(
								     iString.charAt(3).equals( iString.charAt(4) ) // a(3) == a(4)
								     && iString.charAt(3).equals( jString.charAt(3) ) // a(3) == b(3)
								     && jString.charAt(0).equals( jString.charAt(2) ) // b(0) == b(2)
								     
								     && ! jString.contains( iString.charAt(0) ) // b does not contains "t"
								     && ! jString.contains( iString.charAt(1) ) // b does not contains "h"
								     && ! jString.contains( iString.charAt(2) ) // b does not contains "r"
								     && ! iString.contains( jString.charAt(0) ) // a does not contains "n"
								     && ! iString.contains( jString.charAt(1) ) // a does not contains "i"
								    )
								    if( combination1.contains(product) ){
								      combination1.update(product, combination1(product) ::: List( i + "" + j))
								    }
								    else{
								      combination1.update(product, List( i + "" + j ))
								    }
								})
						}
				)

				
( 99999 to 10000 by -3).foreach( 
	i => { (  9999 to 1000 by -9 ).foreach(
					j =>{
					  val product = i * j
					  val iString = i.toString
					  val jString = j.toString
					    if(
					    	iString.toList.toSet.intersect( jString.toList.toSet ).isEmpty
					    )
					    if( combination2.contains(product) ){
						    combination2.update(product, combination2(product) ::: List( i + "" + j) )
						    }
						else{
						    combination2.update(product,  List( i + "" + j ))
						}
					})
			}
)
println( "both set computed" )
	
// a * b -> String( a + " " + b)
// c * d -> String( c + " " + d) 
def matchConditions( lcom1 :List[String], lcom2 :List[String] ) :String ={

  var stringMatch = ""
		lcom1.foreach( str1 => {
		  lcom2.foreach( str2 => {
			  if (
			   	 str1.charAt(0).equals( str2.charAt(0) ) // a(0) == c(0)
			     && str1.charAt(2).equals( str2.charAt(1) ) // a(2) == c(1)
			     && str1.charAt(3).equals( str2.charAt(6) ) // a(3) == d(1)
			     && str1.charAt(5).equals( str2.charAt(5) ) // b(0) == d(0)
			     && str1.charAt(6).equals( str2.charAt(3) ) // b(1) == c(3)
			   ){

			    stringMatch =str1
			    }
		  })
		})
		stringMatch
}


combination1.foreach( t =>{
  
    if(
        // same product
    	combination2.contains( t._1 )){
    		val sameProd = matchConditions( t._2, combination2(t._1) )
    		if( sameProd != "" ){
    		    println( "response : " + sameProd.substring(0, 5).toInt  * sameProd.substring(5, 9).toInt   )
    		}
	  }
})

    // response 120667536

}