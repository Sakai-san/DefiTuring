package problems

import lib.Mathematics


object problem56 extends App {

  val aMin = 1
  val aMax = 250
  val bMin = 1
  val bMax = 250

 val max = (aMin to aMax).flatMap(i => (bMin to bMax).map(
		  		j => BigInt(i).pow(j))).map( k => Mathematics.sumDigitConcise(k.toString) ).max

  println(s"biggest sum is  : $max")
  // response 2797
}