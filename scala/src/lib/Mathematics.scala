package lib

object Mathematics {

  /*
    getFactors gives all factors of an integer
    arg			n integer
    return		List of factors
   */
  def getFactors(n: Int) = {
    var rootN = Math.floor(Math.sqrt(n)).toInt
    var factor = List[Int]()

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

  /*
    isPrime  tells if a integer is a prime number
    arg n     integer
    return    boolean
  */
  def isPrime(n: Int) = {
    var factors = getFactors(n)
    var noDividor = List(1, n)
    // if lists are same then n is a prime
    factors == noDividor
  }

  /*
    factorial gives the factorial number of an integer
    arg			n integer
    return		integer
   */
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }

  /*
    isPalidrome tells if a number-string is a palindrome
    arg			numberString string
    return		boolean
  */
  def isPalindrome(numberString: String): Boolean = {
    if (numberString.length <= 1) true
    else if (numberString.charAt(0).toString == numberString.charAt(numberString.length - 1).toString)
      isPalindrome(numberString.substring(1, numberString.length - 1))
    else false
  }

  /*
	sum gives the sum of integer from 0 to n
	arg			n integer
	return		integer
   */
  def sumToN(n: Int) = {
    n * (n + 1) / 2
  }

}