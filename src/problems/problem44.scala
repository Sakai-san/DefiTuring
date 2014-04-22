package problems
import lib.Mathematics
import scala.util.control.Breaks

object problem44 extends App {

  def differencePentAsWell(pentagonals :  Array[Int], couples :List[(Int,Int)]) :List[(Int,Int)] = {
    var diffPenta = List[(Int,Int)]()
    // couples element must be different and the diff should be a pentagonal
    couples.foreach( el => {
      if( el._1 > el._2 && pentagonals.contains( el._1 - el._2) ){
        diffPenta = diffPenta ::: List((el._1,el._2))
      }
    })
    diffPenta
  }
  
  def pentagonalFunction( n:Int ):Int = {
    n *( 3 *n -1) / 2
  }
  
  var totallyPentNb = 0
  var couplesTotalPent = List[(Int,Int)]()
  var counter = 3
  
  var pentagonals = Array[Int](1)
  var currentPen = 5
  
  val Outer = new Breaks
  Outer.breakable {
    while (true) {

      // let s see is a given pent can be computed as a sum of other pents
      val couplesSum = Mathematics.complementarySum2Natural( pentagonals, currentPen )
      
      // here are couples of pent whose sum is also a pent
      if( !couplesSum.isEmpty ){
        val diffPent = differencePentAsWell(pentagonals, couplesSum)
        // here are couples of pent whose sum is a pent AND the diff is also a pent
        if( ! diffPent.isEmpty) { couplesTotalPent = couplesTotalPent ::: diffPent; totallyPentNb += 1; println( "sum and diff are pentagonals : " + diffPent ) }
      }
      pentagonals = pentagonals :+ currentPen
      currentPen = pentagonalFunction(counter)
     
      if ( totallyPentNb >= 1) {
        Outer.break;
      }
      counter += 1
    }
  }

    // get the shortest D
    println( couplesTotalPent.map( el => { Math.abs(el._1 -el._2) }).min )
  
  // the both penta : 7042750,1560090
  // response D=5482660
}