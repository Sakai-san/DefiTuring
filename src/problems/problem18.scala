package problems

import lib.Mathematics

object problem18 extends App {

  val low = BigInt(1)
  val up  = BigInt(2013)
       
   /*
    * another algorithm
    * val getSublistAbundants = abundants.filter( i => i < K )
    * for all element in the sublist
    * check if a sum is feasible with another (or the same) element in that sublist
    var feasible =  getSublistAbundants.exists( i =>  getSublistAbundants.contains( alea.-(i)) )
   
   */

  
   def allSumCombination( integers :List[BigInt], all :List[BigInt]) :List[BigInt] = {
    if ( integers.isEmpty ) all
    else allSumCombination( integers.tail, List.concat( all, integers.map( k => k.+(integers.head) ) ) )
  }

  val abundants = ( low to up).filter( i => Mathematics.isAbundant(i ) ).toList
  
  val abundantsCombinations = allSumCombination( abundants, Nil ).distinct
  
  val diff = ( low to up).toSet.diff( abundantsCombinations.toSet)
  
  println( abundants )
  println( abundantsCombinations )
  println( diff )
  println( diff.sum )
  
  // response 577167
}