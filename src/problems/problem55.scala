package problems

import lib.Mathematics

object problem55 extends App {

val palProcess =( BigInt(1) to BigInt(10000) ).filter( i=> Mathematics.isLynchrel(i.+ (BigInt( i.toString.reverse) ) ))
println( palProcess.length )

// response 249
}