package problems
import lib.Mathematics
import scala.collection.mutable.HashMap

object problem49 extends App {
  
  // algorithm
  // comprehension list of 4 digit primes
  // hash of those same pattern => primes
  // select only the primes.length >= 3
  // look for an arithmetic subsequence of difference 3330 in all primes list
  
  def serializeHashOfNumber( pattern :Seq[(Int,Int)] ) = {
    var stringTuple = ""
	pattern.foreach(  i=> stringTuple += i._1 +","+ i._2 +";"  )
	stringTuple
  }
  
  // comprehension list of prime with 4 digits
  def allPrimes4Digit( ) ={
    ( BigInt(1001) to BigInt(9999) by 2).filter( i=> Mathematics.isPrime(i))
  }
  
 val hashPatternToPrimes = HashMap[String, List[BigInt]]()
 
// complete the hash : pattern => list of primes
allPrimes4Digit.foreach( {
	 									i=> {
	 									  val pattern = serializeHashOfNumber( Mathematics.hashOfNumber( i ))
	 									  
	 									  if( hashPatternToPrimes.contains(pattern) ){
	 									      hashPatternToPrimes.update( pattern, hashPatternToPrimes(pattern) ::: List(i))
	 										}
	 									  else{
	 									      hashPatternToPrimes.update( pattern, List(i))
	 									  }
 										}
	 									} )

var triplesTuplesOrMore = List[List[BigInt]]()

// select only the list of primes bigger than 3
hashPatternToPrimes.foreach( i=>{ if(  i._2.length >= 3 ) triplesTuplesOrMore = triplesTuplesOrMore ::: List (i._2)    } ) 

// looks for arithmetical subsequence with difference diff (here 3330)
triplesTuplesOrMore.foreach( seq => if( isSequenceOfThree(seq, 3330 )) println(seq  + ", difference : " + 3330  ) )  


// returns true if there is an arithmetic subsequence of length 3
// with the difference diff
// false otherwise
def isSequenceOfThree( seq :List[BigInt], diff :Int ) :Boolean ={
   var differenceToQuantity = HashMap[Int, Int]()
   seq.foreach( p => {
   				(1 to 3333).foreach(
   				    r => {
   				     if( seq.contains( p + r)  ){
   				        if( differenceToQuantity.contains(r) )
   				        	differenceToQuantity.update( r, differenceToQuantity( r) +1)
   				        else
   				        	differenceToQuantity.update( r, 1)
   				     } 
   				    } )
				}
   				)
	
   if(differenceToQuantity.contains( diff ) &&  differenceToQuantity( diff ) == 2 ) true
   else false
 }
 // response is 2969 * 3330 = 9886770
}