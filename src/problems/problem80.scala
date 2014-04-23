package problems

import lib.Mathematics
import scala.collection.mutable.HashMap

object problem80 extends App {

  def hasSameFactorNumber(n: Int, nToFactor: HashMap[Int, Int]): Boolean = {
    var (leftNeib, rightNeib) = (n - 1, n + 1)
    nToFactor.getOrElseUpdate(leftNeib, Mathematics.getFactors(leftNeib).length) == nToFactor.getOrElseUpdate(n, Mathematics.getFactors(n).length) &&
    nToFactor.getOrElseUpdate(n, Mathematics.getFactors(n).length) == nToFactor.getOrElseUpdate(rightNeib, Mathematics.getFactors(rightNeib).length)
  }

  val nToFactorNumber = HashMap[Int, Int]()
  val (low, up) = (2, 2999)
  
  var sameFactorNumber = 0
  (low to up).foreach(i => {
    if (hasSameFactorNumber(i, nToFactorNumber)) sameFactorNumber += 1
  })

  println(s"Number of year having the same factor number : $sameFactorNumber")
  // response 59
}