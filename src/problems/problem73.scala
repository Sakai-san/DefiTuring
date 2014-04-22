package problems

import lib.Mathematics


object problem73 extends App {

  val up = BigInt( 9999999 )
  val low = BigInt( 1000000 )

 val palindromes = (up to low by -1).filter( i => ( Mathematics.isPalindrome(i.toString) && Mathematics.isPalindrome((i*i).toString) ) )

 println( palindromes)
 val head = palindromes.head
 
  println(s"biggest pal whose sqrt is also pal  : $head")
  // response 2001002
}