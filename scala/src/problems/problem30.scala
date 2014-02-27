package problems

import lib.Mathematics._
import scala.util.control.Breaks

object problem30 extends App {

  val power		= 5.0
  val sup		= Math.pow( 9, power+1).toInt
  val sum		=  ( 2 to sup ).filter( i => powerSumEqualToNumber( i, power) ).sum
  
  println( s"the response is $sum" )
  // response 443839
}