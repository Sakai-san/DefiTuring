package problems

import lib.Mathematics

object problem17 extends App {

val low = BigInt(1)
val up = BigInt(100000)
  
/*
 var dfactors = List[List[BigInt]]()
 ( low  to up  ).foreach( i =>
 									{
   										val factors = Mathematics.getFactors(i)
   										if ( factors.length > 2 ){
   										  // remove the last one
   											var d = factors.reverse.tail
   											dfactors = dfactors ::: List( List[BigInt]( i, d.sum) )
   										}
 								}
		 				)


var friends = List[BigInt]()
dfactors.foreach(  i => {
							dfactors.foreach( 
											j => {
												if( i.head != j.head && i.head == j.tail.head && i.tail.head == j.head  )
													friends =  i.head :: friends
												}
											)
									}
							)

println(friends.sum )
*/
// response 852810

// much better way to do this (better data structure)

// data structure is map (hash in other language), index is n and value is d(n)
// so let index i, j such that i != j : 
// d_i = hash[i]
// hash[d_i] == i then i and j are friends

var hashNToD = Map[BigInt, BigInt]()
 ( low  to up  ).foreach( i =>{
   										val factors = Mathematics.getFactors(i)
   										if ( factors.length > 2 ){
   										  // remove the last one
   											var d = factors.reverse.tail
   											hashNToD += ( i -> d.sum) 
   										}
 								}
		 				)


var friends = List[BigInt]()
hashNToD.foreach(
					item => {
							val key = item._1
							val value = item._2
							 // hashNToD.contains(value) is the other index 
							if( hashNToD.contains(value) && hashNToD(value) == item._1 && item._1 != item._2  )
									friends =  item._1 :: friends
						}
				)

println( friends.sum )
}