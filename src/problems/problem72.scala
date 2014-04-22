package problems

import lib.Mathematics

object problem72 extends App {

  val up = Mathematics.sqrt( 1000000000 )
  val low = BigInt( 10 )

  // get all powers which are ending with 3 same last digits
 val same3LastDigits = ( low to up ).filter( i => {val pow= i*i; pow.toString.substring( pow.toString.length-3, pow.toString.length).distinct.length == 1  } )

 println( same3LastDigits )
 
 // remove all the VGAKKK+ pattern, since more than 3 K identical symbol at the bottom of the string
 val sameExclusive3LastDigits = ( same3LastDigits ).filter( i => {val pow= i*i; !pow.toString.substring( pow.toString.length-4, pow.toString.length-3).equals( pow.toString.substring( pow.toString.length-3, pow.toString.length-2)) } )

 println( sameExclusive3LastDigits )
 val size = sameExclusive3LastDigits.length
 
 println(s"how many such numbers  : $size")
 // response 127
  
}