package mtwtkman.s99.p14

object P14 {
  // Duplicate the elements of a list.
  def duplicate[A](ls: List[A]): List[A] = ls flatMap { e => List(e, e) }

  def main(args: Array[String]) {
    println(duplicate(List('a, 'b, 'c, 'c, 'd)))
  }
}
