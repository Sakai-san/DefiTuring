package problems

import scala.util.control.Breaks

object problem2 extends App {

  def sumOddFibonacci(limit: Int) = {
    var ante_term = 1
    var prev_term = 1
    var current_term = 0
    var sum_odd = 0

    val Outer = new Breaks
    Outer.breakable {
      while (true) {
        current_term = ante_term + prev_term
        println("current term is " + current_term)
        ante_term = prev_term
        prev_term = current_term
        var next_term = ante_term + prev_term
        if (next_term > limit) {
          Outer.break;
        }
        if (current_term % 2 == 1)
          sum_odd += current_term
        // do not forget the two firsts initial terms. 
      }
    }
    sum_odd + 1 + 1
  }

  println(sumOddFibonacci(4000000))
  // response 4613732
}