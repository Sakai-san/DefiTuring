package problems
import lib.Mathematics

object problem77 extends App {

  val up =  99999999 
  val low =  10000000 

 val squarePower = (up to low by -1).filter( 
		 	i => ( Math.pow(i.toString.substring(0,4).toInt,2) + Math.pow(i.toString.substring(4,8).toInt,2)  == i)
		 )

 println( squarePower.max )

// response 94122353
}