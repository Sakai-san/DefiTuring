package problems

import lib.Mathematics
import scala.collection.mutable.HashMap

object problem26 extends App {

  def time[A](a: => A) = {
    val seconds = System.nanoTime / (1000 * 1000 *1000)
    seconds
  }

  val up = BigInt(999999999)
  val low = BigInt(111111111)


  val start1 = time()
  val chunkDividable1 = (up to low by -1).filter(i => !i.toString.contains("0") && i.toString.toList.distinct.length == 9 && Mathematics.isChunkDividable(i))
  println(s"chunkDividable  : $chunkDividable1")
  val end1 = time()
  println("Duration of the script 1 (minutes) : " + (end1 - start1) / 60)
  // response 381654729
  
  
  // With memoization, twice faster
  val memo = HashMap[Int, Boolean]()
  def isChunkDividible(n: Int): Boolean = {
    def isChunkD(i: Int): Boolean =
      memo.getOrElseUpdate(i, isChunkDividible(i))

    if (n.toString.length == 1)
      true
    else
      n % n.toString.length == 0 && isChunkD((n.toString.substring(0, n.toString.length - 1)).toInt)
  }

  val start2 = time()
  val chunkDividable2 = (111111111 to 999999999).filter(i => !i.toString.contains("0") && i.toString.toList.distinct.length == 9 && isChunkDividible(i))
  println(s"chunkDividable  : $chunkDividable2")
  val end2 = time()
  println("Duration of the script 2 (minutes) : " + (end2 - start2) / 60)
}