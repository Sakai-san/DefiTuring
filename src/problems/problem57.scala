package problems

import scala.util.control.Breaks

// adapted from http://rosettacode.org/wiki/Arithmetic/Rational
class Rational(n: BigInt, d:BigInt) extends Ordered[Rational]
{
   require(d!=0)
   private val g:BigInt = gcd(n, d)
   val numerator:BigInt= n/g
   val denominator:BigInt = d/g
 
   def this(n:BigInt)=this(n,1)
 
   def +(that:Rational):Rational=new Rational(
      numerator*that.denominator + that.numerator*denominator,
      denominator*that.denominator)
 
   def -(that:Rational):Rational=new Rational(
      numerator*that.denominator - that.numerator*denominator,
      denominator*that.denominator)
 
   def *(that:Rational):Rational=
      new Rational(numerator*that.numerator, denominator*that.denominator)
 
   def /(that:Rational):Rational=
      new Rational(numerator*that.denominator, that.numerator*denominator)
 
   def unary_~ :Rational=new Rational(denominator, numerator)
 
   def unary_- :Rational=new Rational(-numerator, denominator)
 
  // def abs :Rational=new Rational(Math.abs(numerator), Math.abs(denominator))
 
   override def compare(that:Rational):Int=
      (this.numerator*that.denominator-that.numerator*this.denominator).toInt
 
   override def toString()=numerator+"/"+denominator
 
   private def gcd(x:BigInt, y:BigInt):BigInt=
      if(y==0) x else gcd(y, x%y)
}
 

object problem57 extends App {  
  
    var ratio =  new Rational( BigInt(1), BigInt(2) ) 
	var limit = 10000
	var counter = 1
	var numLengthBigger = 0
	
    val Outer = new Breaks
    Outer.breakable {
      while (true) {
        val value = ratio.+(new Rational( 1 ))
        
        // numerator length > denominator length
        if( value.numerator.toString.length > value.denominator.toString.length) numLengthBigger +=1 
        
        if ( counter>= limit ) {
          Outer.break;
        }
        ratio = new Rational(1)./( (  ratio.+(new Rational(2)) ))
        counter += 1
      }
  }

   println( numLengthBigger )
  // response 1508
}