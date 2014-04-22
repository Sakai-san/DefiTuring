package problems
import lib.Mathematics

object problem79 extends App {

  def computeProduct( a : Array[Int] ) :Int ={
    val coeff = Array[Int](2, 4, 6, 8, 10, 12, 14, 16)
    var prod = 1
    for ( i <- 0 to a.length-1 ){
      prod = prod * (coeff(i)- a(i))
    }
    prod
  }
  
var biggestProd = 0

// try all permutations and stores the biggest product
List( 1, 3, 5, 7, 9, 11, 13, 15 ).permutations.foreach( i=>{ 
												val product = computeProduct( i.toArray )
												biggestProd = if( product > biggestProd) product else biggestProd
												}
											)
											
println( s"biggest product = $biggestProd")


// response 15752961
}