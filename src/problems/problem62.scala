package problems

import lib.Mathematics
import scala.collection.mutable.HashMap
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks


object problem62 extends App {

  // algorithm
  // stores i => pattern( pow(i,3) ) into a hashMap
  // (pattern is nothing but a hashMap describing what a pow3 number is composed of) 
  // within the while loop : 
  //		add the current number into the hashMap : current => pattern
  //		check within the whole hashMap whether there are similar pattern computed before.
    

// return all number whose pow 3 pattern is the same
def HowMuchSamePattern( pow3 :BigInt, hashNumberToPow3Pattern :HashMap[BigInt, Seq[(Int,Int)]] ) :ArrayBuffer[BigInt] ={
  val samePattern = ArrayBuffer[BigInt]()
  
  // iterate the hashMap, looking for same pattern
  hashNumberToPow3Pattern.foreach( i=> {
	  // test all pattern in the hash (value) with the current pow3
	  if( i._2 == Mathematics.hashOfNumber( pow3 ) ){
	    samePattern.append( i._1 )
	  }
  })
  samePattern
}



var current = BigInt(1)
// hash stores a number -> the pattern of its power 3
val hashNumberToPow3Pattern = HashMap[BigInt, Seq[(Int,Int)]]() 
var currentSamePattern = ArrayBuffer[BigInt]()

  val Outer = new Breaks

  Outer.breakable {
	 while( true ){
	  val pow3 = current.pow(3)
	  // put it in the hash
	  hashNumberToPow3Pattern.update(current, Mathematics.hashOfNumber( current.pow(3) ) )
	  
	  	// get all numbers whose pow3 pattern is the same
	    currentSamePattern = HowMuchSamePattern( pow3, hashNumberToPow3Pattern )
	  	if(  currentSamePattern.length  == 4 ){
	  		Outer.break
	  	}	  
	  current += 1
	 }
}

println(  currentSamePattern.min.pow(3) )
// response 1006012008
}