package problems

import lib.Mathematics
import scala.collection.mutable.HashMap

object problem14 extends App {

  // With memoization, hashMap : number => syracuse length
  
  
  val memo1 = HashMap[Int, Int]()
  // not tail-recursive
  def syracLength1(n: Int): Int = {
    def memoSyrac1(i: Int): Int =
      memo1.getOrElseUpdate(i, syracLength1(i))

    if (n == 1)
      1
    else // even 
	    if (n % 2 == 0) 1 + memoSyrac1(n / 2)
	    // odd
	    else 1 + memoSyrac1(3 * n + 1)
  }
  
  
  val memo2 = HashMap[Int, Int]()
  def tailRecSyrac(n: Int, acc:Int ): Int = {

    def me(i: Int, acc:Int ): Int =
      memo2.getOrElseUpdate(i, acc + tailRecSyrac(i, 0) )
  
	  if (n == 1)
	    1 + acc
	  else
		// even 
	    if (n % 2 == 0) 
	      me(n / 2, acc + 1 )
	
	   // odd
	   else
		   me(3 * n + 1, acc + 1 )
  }
   
 /*
(3 to 20).foreach(i => {
	  							// we only compute if it possibly can have a bigger size
	  							if( i % 2 == 0 ){
	  							  var beneath = i / 2
	  							  val current_tuple = ( i, tailRecSyrac(i, 0))
	  							  // that current one is bigger
	  							  if( biggest_pairs("even").contains(beneath) ){
	  							    
	  							    // add the current and remove the former bigger
	  							    if( current_tuple._2 > biggest_pairs("even")(beneath)){
		  							    biggest_pairs("even").remove( beneath ) 
	  							    	biggest_pairs("even").update( current_tuple._1, current_tuple._2 )
	  							    }
	  							    // add the current 
	  							    else if( current_tuple._2 >= biggest_pairs("even")(beneath)){ 
		  							    biggest_pairs("even").update( current_tuple._1, current_tuple._2 )
	  							    }
	  							  }
	  							  else{
	  							    biggest_pairs("even").update( current_tuple._1, current_tuple._2 )
	  							  }
	  							}
	  							else{
	  							  var beneath = 3 * i + 1
	  							  val current_tuple = ( i, tailRecSyrac(i, 0))

	  							  // that current one is bigger
	  							  if( biggest_pairs("odd").contains(beneath) ){
	  							  // that current one is bigger
	  							    
	  							    // add the current and remove the former bigger
	  							    if( current_tuple._2 > biggest_pairs("odd")(beneath) ){
		  							    biggest_pairs("odd").remove( beneath ) 
	  							    	biggest_pairs("odd").update( current_tuple._1, current_tuple._2 )
	  							    }
	  							    // add the current 
	  							    else if( current_tuple._2 >= biggest_pairs("odd")( beneath )){ 
		  							    biggest_pairs("odd").update( current_tuple._1, current_tuple._2 )
	  							    }
	  							  }
	  							  else{
	  							    biggest_pairs("odd").update( current_tuple._1, current_tuple._2 )
	  							  }
	  							}
					})
*/

  
// the big issue of that exercise is to make the function tail recusive
// we did it in two steps, first compute the sequence tail-recursively, then compute its length (2 functions)
// with the memoization it was not possible make the function tail-recursive
val all_key_val = HashMap[Int,Int]()
(1 to 1499999).foreach(i => all_key_val.update(i, Mathematics.syracuseLength(i) ) )

// sort by the length
val sortedByLength = all_key_val.toList.sortBy(_._2)

// get the two highest values
println("le nombre : " + sortedByLength.reverse.head._1 + ", la longueur " + sortedByLength.reverse.head._2)
println("le nombre : " + sortedByLength.reverse.tail.head._1 + ", la longueur " + sortedByLength.reverse.tail.head._2)
// response 1117065

}