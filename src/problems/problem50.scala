package problems
import lib.Mathematics
import scala.util.control.Breaks
import scala.collection.mutable.HashMap

object problem50 extends App{
  
  // n -> List of factors
  val memo1 = HashMap[BigInt, List[BigInt]]()  
  val set235 = Set[BigInt](2 , 3 , 5)
  
  def isPrime( n :BigInt, nToFactor :HashMap[BigInt, List[BigInt]] ) :Boolean ={
    
    // the index should be set
    try{
      if( nToFactor(n) == List(1,n) ) true
      else false
    }
    catch{
    	case e: Exception  => println("exception caught: " + e);
    	false
    }
  }
  
  def only2Or3Or5AsPrimeFactor ( n :BigInt ) :Boolean = {
     val factors = Mathematics.getFactors(n)
     memo1.update(n , factors)
     
     // update the hash map with all factors
     factors.foreach( f => {
       if( !memo1.contains(f) ) memo1.update(f, Mathematics.getFactors(f)) 
     })  
     
     // check now within the hashMap
     val primesFactors = factors.filter( f => { isPrime(f, memo1) } )
     
     primesFactors.toSet.diff(  set235  ).isEmpty
  }

  
  
    def only2Or3Or5 ( n :BigInt ) :Boolean = {
     val factors = Mathematics.getFactors(n)
     val primesFactors = factors.filter( f => { Mathematics.isPrime(f) } )
     primesFactors.toSet.diff(  Set[BigInt](2 , 3 , 5) ).isEmpty
  }
  
  
  
  
  
/*
  var counter = BigInt(2)
  var matched       = 0

  val Outer = new Breaks
  Outer.breakable {
    while (true) {

      if ( only2Or3Or5AsPrimeFactor(counter) ) {
        matched += 1
      }
      if( matched >= 2013){
          Outer.break;
       }
      counter += 1
    }
  }
println( counter )
println( memo1 )
*/

  
  /*
  lazy val naturals: Stream[Int] = Stream.cons(1, naturals.map(_ + 1))
  
  val special = naturals.filter( p => {
   
	  			only2Or3Or5(p)
 		}
 	)
 special.take(2013).print
  */
 


    /*
 lazy val ps: Stream[Int] = 2 #:: Stream.from(3).filter(
			 					i =>
	  								only2Or3Or5( i ) )

val r = ps(2013)
println( r )

*/
   println( ( 2 to 10000).filter( i=> !Mathematics.isPrime(i) ) )
    
// response

  
  
}

