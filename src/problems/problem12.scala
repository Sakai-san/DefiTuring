package problems
import lib.Mathematics
import scala.collection.mutable.HashMap
import scala.util.control.Breaks

object problem12 extends App {

  // With memoization, hashMap : number => 1 up to n sum
  val memo1 = HashMap[BigInt, BigInt]()
  // not tail-recursive
  def triangleNumber(n: BigInt): BigInt = {
    def memoSum(i: BigInt): BigInt =
      memo1.getOrElseUpdate(i, triangleNumber(i))

    if (n == 1)
      1
    else n + memoSum( n-1 )
  }
   
  var counter = BigInt(1)

  val Outer = new Breaks
  Outer.breakable {
    while (true) {
      if ( Mathematics.getFactors( triangleNumber(counter) ).length >= 1000 ) {
        Outer.break;
      }
      counter += 1
    }
  }

  println(triangleNumber(counter))
// response is 842161320
}