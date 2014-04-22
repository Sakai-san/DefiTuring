package problems

import lib.Mathematics

object problem11 extends App {

  val upper = 10000000
  var mirrors = (upper to 0 by -1).filter(
		  				i => (4* i == Mathematics.mirror(i) )
		  	)

println( mirrors.head )
// response 2199978
}