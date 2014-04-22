package problems

import lib.Mathematics

object problem71 extends App {

  val up = Mathematics.sqrt( 999999 )
  val low = BigInt( 0 )

 val uniqueDigits = ( low to up ).filter( i => Mathematics.allDigitDifferent( i.toString + (i*i).toString )  ).filter( j => (!j.toString.contains("0") ) )

 println( uniqueDigits)
 val head = uniqueDigits.reverse.head
 
  println(s"biggest unique number  : $head")
  // response 854
}