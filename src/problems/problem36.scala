package problems

import lib.Mathematics


object problem36 extends App {

  val low = 1
  val up = Math.pow(10, 7).toInt-1

  val sum = (low to up).filter(i => Mathematics.isPalindrome(i.toString) && Mathematics.isPalindrome(i.toBinaryString) ).sum
  println(sum)
  // response 25846868
}