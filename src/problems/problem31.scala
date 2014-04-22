package problems
import scala.util.control._

object problem31 extends App {
  
   def time[A](a: => A) = {
    val miliseconds = System.nanoTime / (1000 * 1000 )
    miliseconds
  }

  // do not forget to convert all values to ponds !!! 
  // bad algorithm : brute force
/*
  val start1 = time()
  val total1 :Int = 10*100
  var counter1 = 0
  
  for( a <- (0 to 2 ) ){
   for( b <- (0 to 5 )){
	for( c <- (0 to 10 ) ){
	  for( d <- (0 to 20) ){
		for( e <- (0 to 50) ){
		  for( f <- (0 to 100) ){
		    for( g <- (0 to 200) ){
			    if ( 500*a + 200*b + 100*c + 50*d + 20*e + 10*f + 5*g == total1 ){
			    	counter1 += 1
					}
				}
		    }
		  }
		}
	  }
	}
  }
  println( counter1 )
  val end1 = time()
  println("Duration of the script 2 (milliseconds) : " + (end1 - start1) )
*/
  
 
  
  // do not forget to convert all to ponds !!! slightly optimized algorithm ~100 x faster
/*
    500a + 200b + 100c + 50d + 20e + 10f + 5g = 1000
  	
  	0 <= a <= 2
  		200b <= total - 500a
  		  100c <= total - 500a -200b
  		     50d <= total - 500a -200b -100c
  	  		     20e <= total - 500a -200b -100c -50d
  	  		       10f <= total -500a -200b -100c - 50d -20e
					  5g <= total - 500a -200b -100c - 50d - 20e - 10f
*/

  val start2 = time()
  val total2 :Int = 1000
  var counter2 :Int  =  0
  
  for( a <- (0 to 2 ) ){
   for( b <- (0 to ( (total2 - 500*a )/200.0).floor.toInt  ) ){
	for( c <- (0 to ( (total2 - 500*a -200*b )/100.00 ).floor.toInt ) ){
	  for( d <- (0 to ((total2 - 500*a -200*b -100*c )/50.0).floor.toInt ) ){
		for( e <- (0 to ((total2 - 500*a -200*b -100*c -50*d )/20.0).floor.toInt ) ){
		  for( f <- (0 to ((total2 - 500*a -200*b -100*c -50*d -20*e )/10.0).floor.toInt ) ){
		    for( g <- (0 to ((total2 - 500*a -200*b -100*c -50*d -20*e -10*f )/5.0).floor.toInt ) ){

			    if (  500*a + 200*b + 100*c +50*d + 20*e + 10*f + 5*g == total2 ){
			    	counter2 +=1
					}
				}
		    }
		  }
		}
	  }
	}
  }
  println( counter2  )
  val end2 = time()
  println("Duration of the script 2 (milliseconds) : " + (end2 - start2) )
 
 // reponse 104560
  
}
