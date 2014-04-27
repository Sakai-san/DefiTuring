package lib
import BigInt._
import scala.collection.mutable.HashMap
import scala.util.control.Breaks
import scala.util.Random
object Mathematics {

  /*
    sqrt 			gives the integer sqrt of number
    arg				number BigInt
    return			BigInt
   */

  def sqrt(number: BigInt) = {
    def next(n: BigInt, i: BigInt): BigInt = (n + i / n) >> 1

    val one = BigInt(1)

    var n = one
    var n1 = next(n, number)

    while ((n1 - n).abs > one) {
      n = n1
      n1 = next(n, number)
    }

    while (n1 * n1 > number) {
      n1 -= one
    }

    n1
  }

  /*
    getFactors 		gives all factors of n
    arg				n BigInt
    return			List[BigInt]
   */
  def getFactors(n: BigInt) = {

    // var rootN = Math.floor( Math.sqrt(n) ).toInt
    var rootN = sqrt(n)

    var factor = List[BigInt]()

    for (i <- rootN to 1 by -1) {

      if (n % i == 0) {
        var quotien = n / i

        // for avoiding twice same nb (perfect root)
        if (quotien != i) {
          // push at the top
          factor = i :: factor
          // push at the end
          factor = factor ::: List(quotien)
        } // push at the top
        else {
          factor = i :: factor
        }
      }
    }
    factor
  }

  
   /**
   * This method checks if n is a prime number.
   *
   * @param BigInt
   * @return Boolean
   * @throws java.lang.Exception if n < 0
   */
  def isPrime(n: BigInt): Boolean = {
	  if( n < 0 )  throw new Exception( "n parameter should be a natural number" )
    var factors = getFactors(n)
    var noDividor = List(1, n)
    // if lists are same then n is a prime
    factors == noDividor
  }

    
  
   /**
   * This method computes the greatest common divisor of two integers.
   *
   * @param BigInt, BigInt
   * @return BigInt
   */
  def gcd(x :BigInt, y :BigInt) :BigInt ={
	  if (y == 0) x
	  else gcd(y, x % y)
  }
  
  
   /**
   * This method tells if two integers are coprimes.
   *
   * @param BigInt, BigInt
   * @return Boolean
   */
   def areCoprimes( a: BigInt, b: BigInt ): Boolean = {
	  gcd( a, b ) == 1
  }
  
  
   
   /**
   * This method is the Euler's totient function. Tells how many integer i < n are coprimes with n.
   *
   * @param BigInt
   * @return Int
   */
    def phiEulerTotient( n: BigInt ): Int = {
	  ( BigInt(1) to n.-(1) ).filter( i => areCoprimes(n, i) ).length
    }
   
  
    /*
    getPrimeFactor		tells if n is a prime number
    arg					n BigInt
    return				List[BigInt]
  */
  def getPrimeFactors(n: BigInt): List[BigInt] = {
    getFactors(n).filter( f => isPrime(f) )  
  }

  
  
   /**
   * This method gets the list of couple whose sum equals to n.
   *
   * @param Int
   * @return List[(Int,Int)]
   */
  def getCoupleSum(n: Int): List[(Int, Int)] = {
       // only run the haf way, like Gauss did for the sum of n
    val up = if (n % 2 == 0) (n/2)-1 else Math.floor(n/2.0).toInt
    (1 to up).map( i => {
    							(i, n-i)
     											}).toList
  
  }
  
  
  
   /**
   * This method gets the list of all combination of a given string. Then length of list is n!.
   *
   * @param String
   * @return List[String]
   * 
   * Very short plot describing how the algo works : the generated tree look like this
   * stringPerm( "tom" )
   *
   * 					   p( "", tom)                        
   *          /           	   |               \
   *     p(t,om)      		p(o,tm)          p(m,to)
   *      /    \        	/      \         /      \
   *   p(to,m) p(tm,o) 	p(ot,m) p(om,t)  p(mt,o) p(mo,t)
   *                   
   */
  	def stringPerm( s :String ) :List[String] ={
  	  	var combinations = List[String]()
  		def p( soFar :String, rest : String ){
  		  if( rest == "" ) combinations = combinations ::: List(soFar)
  		  else{
  		    for( i <- (0 to rest.length() -1 ) ){
  		    	val next = soFar + rest(i)
  		    	val remaining = rest.substring(0,i) + rest.substring(i+1, rest.length())
  		    	p( next, remaining )
  		    }
  		  }
  		}
  		p( "", s )
  		combinations
  	}
  	
  	
  /**
   * Same method than above, only data structure change.
   *
   * @param Array[Int]
   * @return List[Array[Int]]
   */
  	 def arrayElementPerm( l :Array[Int] ) :List[Array[Int]] ={
  	  	var combinations = List[Array[Int]]()
  	  	
  		def p( soFar :Array[Int], rest :Array[Int] ){
  		  if( rest.isEmpty ) combinations = combinations ::: List(soFar)
  		  else{
  		    for( i <- (0 to rest.length -1 ) ){
  		    	val next = soFar ++ Array[Int](rest(i))
  		    	val remaining = rest.slice(0,i) ++ rest.slice(i+1, rest.length)
  		    	p( next, remaining )
  		    }
  		  }
  		}
  		p( Array[Int](), l )
  		combinations
  	}
  
  	
   /**
   * This method gets the transposed matrix.
   *
   * @param Array[Array[Int]]
   * @return Array[Array[Int]]
   */
  	def matrixTranspose( m :Array[Array[Int]] ) :Array[Array[Int]] ={
	  val rowNb = m.length
	  val colNb = m(0).length
	  var transposed = Array.ofDim[Int](rowNb,colNb)
	  /*
	  for( i <- (0 to rowNb -1) ){
		  for( j <- (0 to colNb -1) ){
		    transposed(j)(i) = m(i)(j)
		  }
	  }*/
	  
	 m.foreach(r => {
	   
	 })
	  
  	  transposed
  	}
  

  
  	
  	
   /**
   * This method gets the couples whose element's sum equals to s. Element must belong to IN.
   * Algo does only work with natural numbers. Indeed, negative could compensate positive number.
   * eg. sum=10, (-11,21), whereas 21 > sum
   * Algo : 1. sort array
   *		2. break as soon as possible (first level > sum or combination within the second level > sum)
   *
   * @param Array[Int], Int
   * @return List[(Int,Int)]
   * @throws java.lang.Exception if there exist an element e < 0 within the array
   */
  	def complementarySum2Natural( a :Array[Int], s :Int ) :List[(Int,Int)] = {
	
	val as = a.sorted.toList
	if( as.exists(e =>{e<0}) ) throw new Exception( "All Array's elements should be a naturel number." )	
	var couples = List[(Int,Int)]()
    var firstLoop = as
    var copy = as
    
	val Outer = new Breaks
	
		Outer.breakable {
	      while (  true  ) {
	        if(firstLoop.isEmpty || firstLoop.head > s ){Outer.break;}
	        else{
	    	  Outer.breakable {
		    	  while( true ) {
				      if ( copy.isEmpty || (firstLoop.head + copy.head > s) ) {
				          Outer.break;
		    		  }
		    		  else if ( firstLoop.head + copy.head  == s){
		    			  couples = couples ::: List( (firstLoop.head, copy.head  ) )
		    		  }
				      copy = copy.tail
		    	 } // end of second while
	    	  }
	    	  firstLoop= firstLoop.tail
			  copy = as
	    	} // end of else
	     }// end of first while
		}
		couples
    }
  	
  	
  	
 
  /**
   * Generalize the previous method but in a brute force way (O(n^2)).
   */
  	def complementarySumBrute( a :Array[Int], s :Int ) :List[(Int,Int)] = {
  	  var couples = List[(Int,Int)]()
  	  (0 to a.length-1).foreach( i =>{
  			  				(0 to a.length-1).foreach( j=> {
  			  						if( a(i) + a(j) == s ){ couples = couples ::: List( (a(i),a(j) ) )}
  			  				})
  			  			})
  	  couples
  	}
  	
  	
  	
  	
  /**
   * This method gets the chain factorial of n, e.g. 169 -> 363601 -> 1454 -> 169.
   *
   * @param BigInt
   * @return List[BigInt]
   */
  	
  	def chainFactorial( start :BigInt ) :List[BigInt] = {
	  def aux( chain :List[BigInt] ) :List[BigInt] = {
		  if(  chain.contains( sumFactoDigit( chain.head.toString) ))  chain
		  else aux( List(sumFactoDigit(chain.head.toString)) ::: chain )
	  }
	  aux( List(start) )
  	}
  
  	
  /**
   * This method gets a list of n random natural numbers.
   * If limit argument is specified, then each element belongs to [0,limit[.
   * Otherwise each element is an Int.
   *
   * @param Int, Int (limit is optional)
   * @return List[Int]
   */
  	def generateRandomList( size :Int, limit :Int = 0 ) :List[Int] = {
	  if(limit == 0) Seq.fill(size)( Random.nextInt ).toList
	  else{Seq.fill(size)( Random.nextInt(limit) ).toList }
  	}
  	
  	
    /*
    getCoupleFactors	gets the list of couple factors
    arg					n BigInt
    return				List[(BigInt, BigInt)]
  */
  def getCoupleFactors(n: BigInt): List[(BigInt, BigInt)] = {
    
    // getFactors function is slightly redesign for making a perfect root a double
     def getFactorsWithPerfectRoot(n: BigInt) = {

	    // var rootN = Math.floor( Math.sqrt(n) ).toInt
	    var rootN = sqrt(n)
	
	    var factor = List[BigInt]()
	    for (i <- rootN to 1 by -1) {
	      if (n % i == 0) {
	        var quotien = n / i
	
	          // push at the top
	          factor = i :: factor
	          // push at the end
	          factor = factor ::: List(quotien)
	      }
	    }
	    factor
     }
    
    def buildCouple( couples :List[(BigInt, BigInt)], factors :List[BigInt] ) :List[(BigInt, BigInt)] ={
    		if( factors.length == 2 ) couples :::  List( (factors.head, factors.last))
    		else buildCouple(  couples :::  List( (factors.head, factors.last)) , factors.tail.reverse.tail.reverse)
    }
    buildCouple( List(), getFactorsWithPerfectRoot(n) )
  }
  
  
  
   /**
   * This method computes the n-th term of Stern sequence.
   *
   * @param BigInt
   * @return BigInt
   */
    def sternSeq( n: BigInt ) :BigInt = {
    
    if ( n == 0) 0
    else if ( n == 1 ) 1
    else{
      
      if( n % 2 == 0 ){
        sternSeq ( n/2 )
      }
      else{
    	  sternSeq( (n -1)/2) + sternSeq( (n -1)/2 + 1)
      }
    }   
  }
  
    
   /**
   * This method tell if n is circular, e.g. 102 564 is circular since 410 256 / 4 = 102 564 .
   *
   * @param BigInt
   * @return Boolean
   */
    def isCircular( n: BigInt ) :Boolean = {    
	    val leftMostDigit = n.toString.toList.last.toString.toInt
	    val newOne = BigInt(leftMostDigit + ""+  n.toString.reverse.tail.reverse )
	    newOne % n == 0 && n != newOne 
  }
    
    
    
  /*
    factorial gives the factorial number of an integer
    arg			n BigInt
    return		n BigInt
   */
  def factorial(n: BigInt): BigInt = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  /*
    tailRecursiveFactorial gives the factorial number of an integer
    arg			n BigInt
    return		BigInt
   */
  def tailRecursiveFactorial(n: BigInt):BigInt = {

    def fac(accumulator: BigInt, currentRank: BigInt): BigInt = {
      if (currentRank <= 1) accumulator
      else
        fac(accumulator * currentRank, currentRank -1)
    }
    fac(1, n)
  }

  /*
    isPalidrome tells if a number-string is a palindrome
    arg			numberString String
    return		Boolean
  */
  def isPalindrome(numberString: String): Boolean = {
    if (numberString.length <= 1) true
    else if (numberString.substring(0, 1) == numberString.takeRight(1))
      isPalindrome(numberString.substring(1, numberString.length - 1))
    else false
  }


 
  /*
    isPandigital	tells if n is a pandigital number, namely all digits different from 1 to n length
    arg				n BigInt
    return			Boolean
  */
  def isPandigital(n :BigInt): Boolean = {
    // generate a 1 to n list and compare it with the sorted n transformed in string
   (1 to n.toString.length).toList.toString.equals( n.toString.toList.sorted.toString)
  } 
  
  
  /*
    seqPalindrome	gets the palindrome seq ( |seq| <= 100 )
    arg				List[BigInt]
    return			List[BigInt]
  */
  def seqPalindrome(seq: List[BigInt]): List[BigInt] = {

    // process finish
    if (seq.length >= 100 )
		seq
		
	else if ( isPalindrome(( BigInt(seq.head.toString.reverse).+(seq.head)).toString) )
			List( BigInt(seq.head.toString.reverse).+(seq.head) ) ::: seq
		  
	 // process not yet finish
      else
        seqPalindrome(List( BigInt(seq.head.toString.reverse).+(seq.head)) ::: seq)
  }


    /*
    seqMultPersistence	gets the mutiplicative sequence persistence
    arg					List[BigInt]
    return				List[BigInt]
  */
  def seqMultPersistence(seq: List[BigInt]): List[BigInt] = {
    if ( seq.head.toString.length == 1)
		seq
	else
        seqMultPersistence( List( BigInt(multiplicDigitConcise(seq.head.toString)) ) ::: seq )
  }
  
  
  
   /**
   * This method checks if n has an isolated digit.
   *
   * @param BigInt
   * @return Boolean
   */
  def hasIsolatedDigit( n :BigInt ) :Boolean ={
	  var nString = n.toString
	  var hasIsolated = false
	 
	  if ( nString.length == 1 ) hasIsolated = false
	  else if ( nString.length == 2){
	    if ( nString.charAt(0).toString != nString.charAt(1).toString ) hasIsolated = true
	    else hasIsolated = false
	  }
	  else{
		  for ( i <- (1 to (nString.length-2) ) ){
		    if( nString.charAt(i-1) !=  nString.charAt(i) && nString.charAt(i) !=  nString.charAt(i+1) ) hasIsolated = hasIsolated || true
		  }
		  // handles the first char (from left) of the string
		  if( nString.charAt(0) !=  nString.charAt(1)  ) hasIsolated = hasIsolated || true
		  
		  // handles the last char (from right) of the string
		  if( nString.charAt( nString.length -2) !=  nString.charAt( nString.length -1)  ) hasIsolated = hasIsolated || true
	  }
	  hasIsolated
  }
  
  
  
  
   /**
   * This method checks if n is a Lynchrel number. Works only for n <= 10000.
   *
   * @param BigInt
   * @return Boolean
   * // @throws java.lang.Exception if n > 10000
   */
  def isLynchrel( n :BigInt ) :Boolean ={
   //  if( n>10000 )  throw new Exception( "n parameter should be <= 10000" )
    if ( isPalindrome( n.toString ) ) false
    else{
      seqPalindrome( List(n) ).length >= 100 
    }
  }
  
  
  /*
	sum gives the sum of integer from 0 to n
	arg			n Int
	return		Int
   */
  def sumToN(n: Int) = n * (n + 1) / 2

  /*
	sumDigit gives the sum of digit an integer is composed of
	arg			numberString String
	return		Int
   */
  def sumDigit(numberString: String): Int = {
    if (numberString.length == 0) 0
    else
      numberString.substring(0, 1).toInt + sumDigit(numberString.substring(1, numberString.length))
  }

  
  
  def sumDigitConcise(numberString: String) = numberString.map(i => i.toString.toInt).sum

  
    /*
	multiplicDigitConcise	gives the product of digit an integer is composed of
	arg						numberString String
	return					Int
   */
  def multiplicDigitConcise(numberString: String):Int ={
    numberString.map(i => i.toString.toInt).toList.foldLeft(1){
      ( acc, current) => { current * acc }
  }}
  
  
   /**
   * This method computes the sum of factorial digit n is composed of.
   *
   * @param String
   * @return BigInt
   */
  def sumFactoDigit(numberString: String ): BigInt ={
    val nToFacto = HashMap[BigInt, BigInt]()
    		numberString.map( i => nToFacto.getOrElseUpdate( BigInt(i.toString) ,tailRecursiveFactorial(BigInt(i.toString)))).sum
  }

  def allDigitDifferent(numberString: String): Boolean = numberString.distinct.length == 9

  /*
	powerSumEqualToNumber tell if the sum of the digit to the power p, is equal to the number itself
	arg			n BigInt, p Double
	return		Boolean
   */
  def powerSumEqualToNumber(n: BigInt, p: Double): Boolean = n.toString.map(i => Math.pow(i.toString.toDouble, p).toInt).sum == n

  /*
	powerSum			Compute the SUM(x^n) from n=1 to n
	arg					BigInt
	return				BigInt
   */

  def powerSum(x: BigInt, n: BigInt): BigInt = {
    (1 - x.pow((n + 1).toInt)) / (1 - x) - 1
  }

  /*
	powerSumAll			Compute the SUM(x^x) from x=1 to n
	arg					BigInt
	return				BigInt
   */

  def powerSumAll(n: BigInt): BigInt = {
    if (n == 0) 0
    else
      n.pow(n.toInt) + powerSumAll(n - 1)
  }

  def mirror(n: BigInt) = BigInt( n.toString.reverse.toInt )

  /*
	circlePermutations		gives all permutations of a number
	arg						n BigInt
	return					List[BigInt]
   */
  def circlePermutations(n: BigInt): List[BigInt] = {
    val nbPerm = n.toString.length - 1
    def perm(lst: List[BigInt], nPerm: Int): List[BigInt] = {
      if (nPerm == 0)
        lst
      else
        perm(List(BigInt((lst.head.toString.toList.tail ::: List(lst.head.toString.toList.head)).mkString(""))) ::: lst, nPerm - 1)
    }
    perm(List(n), nbPerm)
  }

  /*
	syracuse		gets the syracuse sequence of n
	arg				n BigInt
	return			List[BigInt]
   */
  def syracuse(n: BigInt): List[BigInt] = {

    def auxSyrac(seq: List[BigInt]): List[BigInt] = {
      if (seq.head == 1) seq
      else {
        if (seq.head % 2 == 0) auxSyrac(List(seq.head / 2) ::: seq)
        else auxSyrac(List(3 * seq.head + 1) ::: seq)
      }
    }
    auxSyrac(List(n))
  }

  /*
	syracuseLength	gets the length of the syracuse sequence of n	
	arg				n BigInt
	return			Int
   */
  def syracuseLength(n: BigInt): Int = syracuse(n).length

    /*
	persistenceLength	gets the length of the multiplicative persitence sequence of n	
	arg					n BigInt
	return				Int
   */
  def persistenceLength(n: BigInt): Int = seqMultPersistence(List(n)).length -1
  
  
  
  /*
	isAbundant		tell if n is an abundant number, namely if the sum of its proper factors is bigger that n itself
	arg				n BigInt
	return			Boolean
   */
  def isAbundant(n: BigInt): Boolean = {
    val factors = getFactors(n)
    val realfactors = factors.reverse.tail
    realfactors.sum > n
  }

  /*
	isChunkDividable		test if all left substring of n are dividable according to its related size (eg. 321, 321 % 3 == 0 && 32 % 2 == 0 && 3 % 1 == 0 returns true)  
	arg						n BigInt
	return					Boolean
   */
  def isChunkDividable(n: BigInt): Boolean = {

    def recCheck(offset: Int): Boolean = {
      if (offset == 1) true
      else {
        BigInt(n.toString.substring(0, offset)) % offset == 0 && recCheck(offset - 1)
      }
    }

    recCheck(n.toString.length)
  }

  
  
  /*
	isPrimeTruncLeft		
	arg						n BigInt
	return					Boolean
   */
  def isPrimeTruncLeft(n: BigInt): Boolean = {
    if (n.toString.length == 1)
      isPrime(n)
    else if (!isPrime(n)) false
    else true && isPrimeTruncLeft(BigInt(n.toString.tail))
  }

  /*
	isPrimeTruncRight		
	arg						n BigInt
	return					Boolean
   */
  def isPrimeTruncRight(n: BigInt): Boolean = {
    if (n.toString.length == 1)
      isPrime(n)
    else if (!isPrime(n)) false
    else true && isPrimeTruncRight(BigInt(n.toString.substring(0, n.toString.length - 1)))
  }

  def isPrimeTrunc(n: BigInt): Boolean = {
    isPrimeTruncLeft(n) && isPrimeTruncRight(n)
  }

  
    /*
	hashOfNumber			gives the hash of digits a number is composed of		
	arg						n BigInt
	return					Seq[(Int, Int)]
   */
   def hashOfNumber(n: BigInt): Seq[(Int,Int)] = {
    val pattern = HashMap[Int, Int]()
    for( i <-  n.toString.toList ){
    	val currentInInt = i.toString.toInt
    	if( pattern.contains( currentInInt) ) pattern.update( currentInInt, pattern(currentInInt) + 1 )    	
    	else pattern.update( currentInInt, 1 )
    }
     pattern.toSeq.sortBy(_._1)
  }

   
 // if preimage does exist the return it
// else returns 0
def triangularInverse( n: BigInt ) :Int = {
  val rank = (Math.sqrt( (8*n + 1).toDouble) - 1 ) / 2 
  if( rank.isValidInt ) rank.toInt
  else 0
}

// if preimage does exist the return it
// else returns 0
def pantagonalInverse( n: BigInt ) :Int = {
  val rank = (Math.sqrt( (24*n + 1).toDouble) + 1 ) / 6 
  if( rank.isValidInt ) rank.toInt
  else 0
}

// if preimage does exist the return it
// else returns 0
def hexagonalInverse( n: BigInt ) :Int = {
  val rank = (Math.sqrt( (8*n + 1).toDouble) + 1 ) / 4 
  if( rank.isValidInt ) rank.toInt
  else 0
}

   
   
  
}