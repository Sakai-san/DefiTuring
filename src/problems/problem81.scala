package problems

import lib.Mathematics
 
object problem81 extends App {
	var up = Mathematics.sqrt(BigInt(999999999))
    var l = List[BigInt]()
	for ( i <- BigInt(1) to up ){ 
		val square = i * i
		var miror = Mathematics.mirror( square )
		var rootMiror = Math.sqrt( miror.toDouble)
		if( rootMiror.isValidInt && Mathematics.mirror( rootMiror.toInt) == i ){
		  l :::= List(i*i)
		}
	}
	println( l.max)
}
// reponse 967894321