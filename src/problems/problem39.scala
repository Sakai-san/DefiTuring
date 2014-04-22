package problems

import lib.Mathematics
import scala.collection.mutable.HashMap
import scala.collection.immutable.SortedMap

object problem39 extends App {

  /*
   * Very unefficiant way to do it
   * 
  def pytagoreanTriple( perimeter : Int) :List[List[Int]] = {
    val low =1
    val up = perimeter -1
  var triple = List[List[Int]]()
  def computeTriple() = {
      
 	(low to up).flatMap(i => (low to up ).map(
	    j => {
	      val cPow = Math.pow(i, 2) + Math.pow(j, 2)
	      val c = Math.sqrt(cPow)
	      if (c.isValidInt && i + j + c.toInt == perimeter ) {
	        triple = triple ::: List(List(i, j, c.toInt))
	      }
	    }
	   )
	  )
	  }
	  computeTriple()
	  triple
  }
  */

  
  def pytagoreanTriple(perimeter: Int): List[List[Int]] = {
    val low = 1
    val up = perimeter - 2
    var triple = List[List[Int]]()
    def computeTriple() = {
      
      // only run the haf way, like Gauss did for the sum of n
      (low to Math.ceil(up/2.0).toInt).map( i => {
        // the only dependent variable is b, since a is fixed in (then only one loop is needed)
        // the following equation a + b + sqrt( a*a + b*b ) = p
        val j = (perimeter * perimeter -2*perimeter*i) / (2*perimeter - 2*i) 
        val cPow = Math.pow(i, 2) + Math.pow(j, 2)
        val c = Math.sqrt(cPow)
        if (j.isValidInt && c.isValidInt && i + j + c.toInt == perimeter) {
        triple = triple ::: List(List(i, j, c.toInt))
        }
     })
    }
    computeTriple()
    triple
  }

  val perimeterToSize = HashMap[Int, Int]()

  (3 to 10000).map(p => perimeterToSize.update(p, pytagoreanTriple(p).length))
  
 
  
  // exchange key => value to value => key
  val revert = perimeterToSize map { _.swap }

  // sort by key (key is now the size and the value is the perimeter
  val sizeToPerimeter = SortedMap(revert.toSeq: _*)

  println(sizeToPerimeter)
  
  // get the p whom there are the most triple
  println(sizeToPerimeter.toList.reverse.head._2)
  // response 9240
  
  // 40/2 different triples p=9240. The more the triangle big is the more triple it could have
  println( sizeToPerimeter.toList.reverse.head._1 )

}