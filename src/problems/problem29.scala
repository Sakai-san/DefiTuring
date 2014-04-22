package problems

object problem29 extends App {

  val aMin = 2
  val aMax = 1000
  val bMin = 2
  val bMax = 1000

  /*
  var powers = (aMin to aMax).map(i => (bMin to bMax).map(
    j => BigInt(i).pow(j)))
  val flatten = powers.flatten.distinct
  val flattenLength = flatten.size
  println(s"number of distinct power is : $flattenLength")
*/

  var powr = (aMin to aMax).flatMap(i => (bMin to bMax).map(
    j => BigInt(i).pow(j)))

  val distinct = powr.distinct
  val distinctLength = distinct.size
  println(s"number of distinct power is : $distinctLength")
  // response 977358
}