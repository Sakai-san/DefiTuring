package problems
import lib.Mathematics
import scala.collection.mutable.ArrayBuffer

object problem32 extends App {

  def completePattern ( n :BigInt ) :Boolean = {
     Mathematics.hashOfNumber(n) == ArrayBuffer[(Int,Int)]( (1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9, 1) )
  }

var completeProduct = List[BigInt]()
// root of 987654321 has been taken as a up max, since size( a, f, p) <= 9
(BigInt(1) to BigInt( Math.pow(987654321,0.5).toInt ) ).foreach( t => {
										val couples = Mathematics.getCoupleFactors(t)
										couples.foreach( c => {
											if( completePattern( BigInt( c._1 + "" + c._2 + "" + t) ) )
											  completeProduct = completeProduct ::: List(  t )
											}
										) }
								)

println( completeProduct.toList.distinct.sum )  
// remark : crazily some products appear many times, namely : (18,297,5346), (27,198,5346), (12,483,5796), (42,138,5796)
// that's why the distinct method has been called
								
// response 45228
}