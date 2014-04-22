package problems


import lib.Mathematics
import scala.collection.mutable.HashMap

object problem59 extends App {
  
  def getIntouchables( sumDToN :HashMap[BigInt, List[BigInt]] ) :List[BigInt] = {
	var intouchables = List[BigInt]()
	
    sumDToN.foreach( el =>{
    		val key		= el._1
    		val value	= el._2
    		
    		value.foreach( l => {
    		 if( ! sumDToN.contains( l ) ){
    		    	intouchables = intouchables ::: List( l )
    		 }
    		 // also the case when 6 -> 6 for example
    		 else{
    		   if( sumDToN( l ).contains(l) )
    		     println( "remove " + l )
    		 }
    		}) 
  })
    intouchables
 }
  
  

  
// data structure is map (hash in other language), index is n and value is d(n) [Sum of proper dividor of n]
// so let index i, j such that i != j : 
// d_i = hash[i]
// hash[d_i] == i then i and j are friends (means that "touchable")

  
 val low = BigInt(1)
 val up = BigInt(100000)

 // first compute all d(n) [sum of proper dividor] => List n
 val hashSumdToN = HashMap[BigInt, List[BigInt]]()
 ( low  to up  ).foreach( i =>{
									val factors = Mathematics.getFactors(i)
									//if ( factors.length > 2 ){
									  // remove the last one
										var d = factors.reverse.tail
										var dSum = d.sum
										if( hashSumdToN.contains( dSum ) ) 
											hashSumdToN.update( dSum, hashSumdToN( dSum ) ::: List(i) )
										else
											hashSumdToN.update( dSum, List(i) )
									//}
 								}
		 				)
		 				
println( "intouchables " )
println( getIntouchables( hashSumdToN ).sorted )

var touchKEqSumK = getLittleTouchableSumIsK( (BigInt(1) to BigInt(666)).toList.toSet.diff( getIntouchables( hashSumdToN ).filter( i => {i<= 666}).toSet ).toList )

println(touchKEqSumK)
println(touchKEqSumK.max)

def getLittleTouchableSumIsK( touchable :List[BigInt] ) :List[BigInt] = {
   var touchables = List[BigInt]()

   touchable.foreach( t => {
	 var d = Mathematics.getFactors( t ).reverse.tail
	 var dSum = d.sum
     if( dSum == t ){
    	touchables = touchables ::: List(t) 
     }
   })
   touchables
}

}