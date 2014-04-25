package problems
import lib.Mathematics
import scala.util.control.Breaks

object problem46 extends App{
  
  def followGoldbachHypothesis( primeList : List[BigInt], oddInt : BigInt ):Boolean = {
	 var primes :List[BigInt] = primeList
	 var suitGoldbach = false
	  val Outer = new Breaks
	  Outer.breakable {
	    while ( !primes.isEmpty ) {
	      val currentPrime = primes.head
	      
	      val remain = (oddInt-currentPrime)./( 2 )
	      val remainSrqt = Math.sqrt(remain.toDouble)
	      if ( remainSrqt.isValidInt ) {
	        suitGoldbach = true
	        Outer.break;
	      }
	      primes = primes.tail
	    }
	  }
	 suitGoldbach
  }
  
 
val primes = List(BigInt(2)) ::: (BigInt(3) to BigInt(10000) by 2).filter( i=> Mathematics.isPrime(i) ).toList 

 var counter = BigInt(3)

  val Outer = new Breaks
	  Outer.breakable {  
	    while ( true && counter < 10000) {
	    	val primesBelow = primes.filter( p => p < counter )
	    	// counter must no be a prime
	        if( !primes.contains(counter) && !followGoldbachHypothesis(primesBelow, counter) )
	        	Outer.break;
	        counter +=2
	     }
	  }
println ( counter )

// response 5777

}