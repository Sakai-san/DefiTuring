package problems

import lib.Mathematics

object problem54 extends App{

  var BigMultiplicande = 0
  
  ( 10000 to 99999 ).foreach( multiplicande => {
    
	  					(10 to 99 ).foreach( multiplicateur => {
	  						val product = multiplicande * multiplicateur
	  						if( 
	  						    product.toString.length == 6 &&
	  						    product.toString.substring(4,5) != "2" &&
	  						    product.toString.substring(5,6) != "2" &&
	  						    product.toString.substring(0, 4) == "2222" &&
 						  	
	  						  	multiplicande.toString.substring(0,1) != "2" &&
	  						  	multiplicande.toString.substring(1,2) == "2" &&
	  						  	multiplicande.toString.substring(2,3) != "2" &&
	  						  	multiplicande.toString.substring(4,5) != "2"
	  						  ){
	  						 	BigMultiplicande = multiplicande
	  						  }
	  					} )
  					})

println( BigMultiplicande )  					
// response 12348
}