package problems

import lib.Mathematics

object problem22 extends App {

 val min = BigInt(111111)  
 val max = BigInt(125000-1 ) // since 8 * 125000 has 9 digits (10^6)

( min to max ).foreach(
		  				i => {
		  				  (min to max).foreach(
		  					j => {
		  					 if(
		  					i != j
		  					&& Mathematics.hashOfNumber(i) == Mathematics.hashOfNumber(i * 8)
		  					&& Mathematics.hashOfNumber(j) == Mathematics.hashOfNumber(j * 8)
		  					&& Mathematics.hashOfNumber(i) == Mathematics.hashOfNumber(j) )
		  					   println( "i = " +i +",j = " + j +", sum = " + (i+j))
		  				})
		  		} )
  
// response both number = i = 113967,j = 116397, sum = 230364
// can be optimized going out of the loop when found
}