package problems
import lib.Mathematics

object problem24 extends App {

var counter = 1
var perm2mil = List[Int]()
List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ).permutations.foreach( i=>{ 
														if(counter == 2000000 ){
														  perm2mil = i
														 }
														counter += 1
														}
												) 
println(perm2mil.mkString(""))

// response 5468731092
}