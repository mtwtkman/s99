package mtwtkman.s99.p04

object P04 {
  // Find the number of elements of a list.
  def lengthBuiltin[A](ls: List[A]): Int = ls.length

  def lengthRecursive[A](ls: List[A]): Int = ls match {
    case Nil => 0
    case _ :: tail => 1 + lengthRecursive(tail)
  }

  def lengthTailRecursive[A](ls: List[A]): Int = {
    def lengthR(result: Int, curList: List[A]): Int = curList match {
      case Nil => result
      case _ :: tail => lengthR(result + 1, tail)
    }

    lengthR(0, ls)
  }

  def main(args: Array[String]) = {
    println(lengthBuiltin(List(1, 1, 2, 3, 5, 8)))
    println(lengthRecursive(List(1, 1, 2, 3, 5, 8)))
    println(lengthTailRecursive(List(1, 1, 2, 3, 5, 8)))
  }
}
