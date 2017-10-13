package mtwtkman.s99.p07

object P07 {
  // Flatten a nested list structure.
  def flatten(ls: List[Any]): List[Any] = ls flatMap {
    case ms: List[_] => flatten(ms)
    case e => List(e)
  }

  def main(args: Array[String]) = {
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }
}
