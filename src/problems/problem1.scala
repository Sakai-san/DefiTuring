package problems
import lib.Mathematics
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer

object problem1 extends App {
  
  // returns the some of 5 and 7 factors from the start to end range
  def sum5And7(start: Int, end: Int): Int = {
    if (start > end) 0
    else if (start % 5 == 0 || start % 7 == 0) start + sum5And7(start + 1, end)
    else sum5And7(start + 1, end)
  }

  println(sum5And7(0, 2013))

  // better way (inclusion-exclusion principle)
  def sumMultiples(limit: Int, a: Int) = {
    Mathematics.sumToN(Math.floor((limit - 1) / a).toInt) * a
  }

  println(sumMultiples(2013, 5) + sumMultiples(2013, 7) - sumMultiples(2013, 35))

  // response 636456
  
    
    /*
  println( "Hello entre une ligne please : " )  
  var inputUser = readLine()
  var formated = inputUser.split(" ")
  var numbers = formated.filter( w => w.matches("^[1-9][0-9]*$") )
  
  for ( n <- numbers ) print( n + " ")
  println( numbers.map( str => str.toInt).sum )
     */
  
  var matrix = Array[Array[Int]]( Array[Int](1,2,3), Array[Int](5,6, 7), Array[Int](9,10,11))
  // val result = (0  until matrix.size).filter( matrix(_)(1) ).toList
  // result.forEach(println)
  
  
  println( Mathematics.chainFactorial(169))
  
    println( Mathematics.matrixTranspose( matrix ) )
    val l = Array[Int](1, 2, 3, 4, 5 )
    Mathematics.arrayElementPerm(l).foreach( ar => println(ar.toList))

  /*
  
  def getElementColMatrix( matrix :Array[Array[Int]], col :Int) :List[Int] ={
	  val nbRow = matrix.length
	  var colElement = List[Int]()
	  for( i <- (0 to nbRow-1) ){  colElement = colElement ::: List(matrix(i)(col)) }
	  colElement
  }
  
  println( getElementColMatrix( matrix, 1 ) )
*/

}