package problems

import scala.collection.mutable.ArrayBuffer

object problemSpecial2 extends App {

  def solution( a :ArrayBuffer[Int], complement :Int) :Int = {
   var howManyComplement = 0
    
    for ( i <- (0 to (a.length -1)) ){
         for ( j <- (0 to (a.length -1)) ){
        	 if( i != j && a(i)+ a(j) == complement ){
        	   howManyComplement = howManyComplement + 1
        	 }
         }
    }
    howManyComplement /2
  }
  
  
   def solution2( a :ArrayBuffer[Int], complement :Int) :Int = {
   var howManyComplement = 0
   val temp = a
   var j = 0
    for ( i <- (0 to (a.length -1)) ){
    	 if( i != j && a(i)+ a(j) == complement ){
    	   howManyComplement = howManyComplement + 1
    	 }
    	 j =0
     }
    howManyComplement
  }
  
  val arr = ArrayBuffer[Int](2, 3, 1, 5, 4)
  // { (2, 4); (1, 5)  }
  println( solution( arr, 6 ))
}