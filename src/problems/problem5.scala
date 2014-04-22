package problems

import lib.Mathematics
 
object problem5 extends App {

  println( BigInt(2).pow(2222).toString.toList.map( i=> i.toString.toInt).sum )
  // response 2830
}
