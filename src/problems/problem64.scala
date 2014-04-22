package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem64 extends App {

  // the present algo use a memoization process
  
  // n => length
  val memo1 = HashMap[Int, Int]()

  def syracLength(n: Int): Int = {
    def memoSyrac(i: Int): Int =
      memo1.getOrElseUpdate(i, syracLength(i))

    if (n.toString.length == 1)
      0
    else
      1 + memoSyrac(Mathematics.multiplicDigitConcise(n.toString))
  }

  (1 to 1000000).foreach(i => {
	  // store the top level one also
      memo1.getOrElseUpdate(i, syracLength(i))
  })
 
  
  // sort by the length
  val sortedByLength = memo1.toList.sortBy(_._2)
  
  // get the highest length
  var highestLength = sortedByLength.reverse.head._2
  println( "The highest length : "+  highestLength )
  
  // get the min N among those with the highest length
  val allNWithHighestLength = sortedByLength.filter( t => t._2 == highestLength )
  val min  = allNWithHighestLength.sortBy(_._1).head._1
  
  println( "min N among those with the highest length : "+ min )

  // response 68889
}