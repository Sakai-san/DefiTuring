package problems

import lib.Mathematics

object problem19 extends App {

  def otherBeingSeq ( end:Int, planet :String ) :List[Int] ={
    var ringFingerNumbers = List[Int]()
    var cycle = 2
    var currentValue = 2
    
    while( currentValue <= end ){
      ringFingerNumbers :::= List(currentValue)
      if( cycle % 2 ==  0 ){
        currentValue = if(planet == "blue") currentValue + 10 else currentValue + 12
      }
      else{
    	currentValue += 2
      }
      cycle +=1
    }
    ringFingerNumbers
  }
  val up = 2013
println( otherBeingSeq( up, "blue").toSet.intersect(otherBeingSeq(up, "green").toSet ).sum )
  
// response 94848
}