package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem65 extends App {

  def sumNWithDigitProduct( n :Int ) :Int ={
    n + Mathematics.multiplicDigitConcise(n.toString)
  }
  
  // K  <= k + productDigit( K )
  
  println(
      // do not include 2014, cause the the task mention "the other numbers", meaning except 2014
      (1 to 2013).filter(i => {
			  sumNWithDigitProduct(i) == 2014
  }).sum
  )
    // response 7407
}