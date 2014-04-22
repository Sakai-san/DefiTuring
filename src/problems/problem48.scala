package problems

import lib.Mathematics

object problem48 extends App {

  val to		= 2013

  val sumpower = Mathematics.powerSumAll( to )
  println( Mathematics.powerSumAll( to ) )

  println( sumpower.toString.substring(0, 10) )
  // response 443839
}

