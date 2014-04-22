package problems
import lib.Mathematics
import scala.util.control.Breaks

object problem78 extends App {

  
  def aPowbCPowD( start : Int, end : Int ) : Int = {

   var counter = start
    
   val Outer = new Breaks
    Outer.breakable {
                
      while (true) {
        
       val a :Int = counter.toString.charAt(0).toString.toInt
	   val b :Int = counter.toString.charAt(1).toString.toInt
	   val c :Int = counter.toString.charAt(2).toString.toInt
	   val d :Int = counter.toString.charAt(3).toString.toInt
	   
	   val aPowB = BigInt(a).pow(b)
	   val cPowD = BigInt(c).pow(d)
  
        if ( aPowB *cPowD == counter ) {
          Outer.break;
        }
        counter += 1
      }
    }
   counter
  }
  
  val low =  1000
  val up =  1002
  
println( aPowbCPowD (low, up )) 
// response 2592
}