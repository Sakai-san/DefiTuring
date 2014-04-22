package problems

import lib.Mathematics

object problem21 extends App {

  val all_digit_diff = ( 1 to 2013 ).filter( i => i.toString.distinct.length() == i.toString.length() ).toArray
  var differences = List[Int]()
  for( i <- 0 to all_digit_diff.length -2 ){differences = differences ::: List( all_digit_diff(i+1) - all_digit_diff(i) )}
 
  println( s"reponse : ${all_digit_diff.length}*${differences.max} = " +all_digit_diff.length * differences.max ) 
// response 1243*105 = 130515
}