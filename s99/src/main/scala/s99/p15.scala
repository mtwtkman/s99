package mtwtkman.s99.p15

object P15 {
  // Duplicate the elements of a list a given number of times.
  def duplicateN[A](n: Int, ls: List[A]): List[A] =
    ls flatMap { x => List.fill(n)(x) }

  def main(args: Array[String]) {
    println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
  }
}
