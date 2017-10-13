package mtwtkman.s99.p13

object P13 {
  // Run-length encoding of a list (direct solution).
  def encodeDirect[A](ls: List[A]): List[(Int, A)] = {
    if (ls.isEmpty) Nil
    val (packed, next) = ls span { _ == ls.head }
    (packed.length, packed.head) :: encodeDirect(next)
  }

  def main(args: Array[String]) {
    println(encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}
