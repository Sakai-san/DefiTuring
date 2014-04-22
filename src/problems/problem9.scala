package problems

import lib.Mathematics

object problem9 extends App {

  val low = 1
  val up = 3598

  var triple = List[List[Int]]()
  
(low to up).flatMap(i => (low to up).map(
    j => {
      val cPow = Math.pow(i, 2) + Math.pow(j, 2)
      val c = Math.sqrt(cPow)
      if (c.isValidInt && i + j + c.toInt == 3600 ) {
        triple = triple ::: List(List(i, j, c.toInt))
      }
    }
   )
  )
  
  println(s"All pythagorean triple  : $triple")
  
  val biggestProduct = triple.foldLeft(0){ (max, current) => {
    
    val product = current.foldLeft(1){_ * _}
    if( product > max ){
      println("biggest product " + current + ", product :" +product)
    	product
  	}
    else
     max
  	}
  }

    println(s"Biggest product  : $biggestProduct")
  // response 1654329600
}