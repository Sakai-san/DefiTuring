package problems

import lib.Mathematics
import scala.collection.mutable.HashMap
import scala.collection.SortedMap

object problem27 extends App {

  
  val abToPrimeLength = HashMap[String, Int]()

  
  def lengthOfPrimeSeq(a: Int, b: Int): Unit = {

    def polynom(n: Int, a: Int, b: Int): Int = {
      n * n + a * n + b
    }
    var currentX = 0
    var currentY = polynom(currentX, a, b)
    var counter = 0
    try{
          while (Mathematics.isPrime(currentY)) {
		      counter += 1
		      currentX += 1
		      currentY = polynom(currentX, a, b)
          }
         abToPrimeLength.update(a + "," + b, counter)
    }
    catch{
      case e: Exception  => println("exception caught: " + e);
    }

  }


val aMin, bMin = -1500
val aMax, bMax = 1500
    
  (aMin to aMax by 1).foreach(
    a => {
      (bMin to bMax by 1).foreach(
        b => {
        	lengthOfPrimeSeq(a, b)
        })
    })

    
 // exchange key => value to value => key
  val revert = abToPrimeLength map { _.swap }

  // sort by key (key is now the length and the value is the a and b value "a,b")
  val lengthToAB = SortedMap(revert.toSeq: _*)
 
  // get the a, b whose generate the most biggest sequence
 val aAndB = lengthToAB.toList.reverse.head._2.split(",")
 val a = aAndB(0)
 val b = aAndB(1)
 println( "a = " + a +", b = " + b +", product " + (a.toInt * b.toInt) )
 // response -75 *1447 = -108525
}