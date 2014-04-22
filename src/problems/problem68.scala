package problems

import lib.Mathematics


object problem68 extends App {

  val up = Mathematics.sqrt( 99999 )
  val low =  Mathematics.sqrt( 10000 )

 val uniqueLeft = ( low to up ).filter( i => {
	 											val pow = i.pow(2)
	 											// S == S && I == I && TRO unique && X !belongs to TRO && left all diff && right all diff
	 											i.toString.substring(0,1).equals( pow.toString.substring( pow.toString.length -1, pow.toString.length) ) &&
	 											i.toString.substring(1,2).equals( pow.toString.substring( pow.toString.length -2, pow.toString.length -1) ) &&
	 											! pow.toString.toList.distinct.contains(i.toString.substring(i.toString.length -1, i.toString.length) ) &&
	 											i.toString.toList.distinct.length == 3 &&
	 											pow.toString.toList.distinct.length == 5
 											}
 										)

 println( uniqueLeft.head.pow(2) )

  println(s"right equation  : $uniqueLeft")
  // response 28561
}