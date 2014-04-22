package problems

import lib.Mathematics

object problem63 extends App {

 

  val bMin		= BigInt(1)
  val bMax		= BigInt(10)
  
  val expMin	= BigInt(1)
  val expMax	= BigInt(21)
  // 21 exp is the max for compensate the base for 9 (since base < 10 ) 
 
  var puiss = List[List[BigInt]]()
 ( bMin to bMax ).flatMap( 
		 			b =>{
		 				( expMin to expMax ).map(
		 				    e =>{
			 				    	val pui = b.pow( e.toInt )
			 				    	// size == expt
		    						if( pui.toString.length == e ){
		    						  puiss = puiss ::: List( List( b, e ) )
		    						}
		 				    	}
	    				)
	    				}
	    			)
	    			
 println( puiss )  
 val puissLength = puiss.length
 println( s"cardinal de [ taille(n) = b^n ] = $puissLength" )
 // response = 49
}