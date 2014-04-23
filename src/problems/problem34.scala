package problems

import lib.Mathematics

object problem34 extends App {

val pairSumFacto = (BigInt(0) to BigInt(1000000) ).map( t => { ( t, Mathematics.sumFactoDigit( t.toString ) ) } ) 
// ( pairSumFacto ).filter( (i) => i._1 >= i._2 ).map ( k=>  println( k._1, k._2 )  )

println(" equal each other ") 
( pairSumFacto ).filter ( k=>  ( k._1 == k._2 )  ).map ( k=>  println( k._1, k._2 )  )
  
// (145, 40585 ) only
// response 5884825
}