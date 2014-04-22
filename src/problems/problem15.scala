package problems

import lib.Mathematics

object problem15 extends App {

var biggestProdSum = 0
var smallestProdSum = 10000

// only try all permutations and stores the product sum if biggest or smallest then previous vector
List(1, 2, 3, 4, 5, 6, 7, 8, 9 ).permutations.foreach( i=>{ 
												val row1 = i.slice(0, 3)
												val row2 = i.slice(3, 6)
												val row3 = i.slice(6, 9)
												
												val col1 = List( row1(0), row2(0), row3(0) )
												val col2 = List( row1(1), row2(1), row3(1) )
												val col3 = List( row1(2), row2(2), row3(2) )
												
												val rows = List( row1, row2, row3)
												val cols = List( col1, col2, col3)
												
												val productSum = (rows.map( i=> i.product )).sum + (cols.map( i=> i.product )).sum
												biggestProdSum = if( productSum > biggestProdSum) productSum else biggestProdSum
												smallestProdSum = if( productSum < smallestProdSum) productSum else smallestProdSum
												}
											)
											
println( s"product smallest ($smallestProdSum) * biggest ($biggestProdSum) = " + smallestProdSum * biggestProdSum)


  def getElementColMatrix( matrix :Array[Array[Int]], col :Int) :List[Int] ={
	  val nbRow = matrix.length
	  var colElement = List[Int]()
	  for( i <- (0 to nbRow-1) ){  colElement = colElement ::: List(matrix(i)(col)) }
	  colElement
  }



// let's do it by our own means !!!
var biggestProductSum = 0
var smallestProductSum = 10000

Mathematics.arrayElementPerm(Array[Int](1,2,3,4,5,6,7,8,9)).foreach( a=> {  
  var (row1 :Array[Int], row2 :Array[Int], row3 :Array[Int]) = (a.slice(0,3), a.slice(3,6), a.slice(6,9))
  var matrix = Array[Array[Int]]( row1, row2, row3)

  var (productOfRows, productOfCols) = (List[Int](),List[Int]())
  matrix.toList.foreach( r => { productOfRows = productOfRows ::: List(r.product) })
  
  for( c <- (0 to matrix(0).length-1) ){ productOfCols = productOfCols ::: List( getElementColMatrix( matrix, c ).product )  }
  val sumOfProduct = productOfRows.sum + productOfCols.sum 
  biggestProductSum = if( sumOfProduct> biggestProductSum) sumOfProduct else biggestProductSum
  smallestProductSum = if( sumOfProduct < smallestProductSum) sumOfProduct else smallestProductSum
  
})

println( s"product smallest ($smallestProductSum) * biggest ($biggestProductSum) = " + smallestProductSum * biggestProductSum )
// response 412892
}