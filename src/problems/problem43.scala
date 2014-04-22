package problems

import lib.Mathematics

object problem43 extends App {

println( (BigInt(1) to BigInt(Math.sqrt(99999999999999.0).toInt) ).filter( k=> Mathematics.isPalindrome( (k * k).toString ) ).sum)

// response 27974694
}