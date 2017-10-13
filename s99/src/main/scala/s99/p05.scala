package mtwtkman.s99.p05

object P05 {
  // Reverse a list.
  def reverseBuiltin[A](ls: List[A]): List[A] = ls.reverse
  def reverseRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => reverseRecursive(tail) ::: List(h)
  }

  def reverseTailRecursive[A](ls: List[A]): List[A] = {
    def reverseR(result: List[A], curList: List[A]): List[A] = curList match {
      case Nil => result
      case h :: tail => reverseR(h :: result, tail)
    }
    reverseR(Nil, ls)
  }

  def main(args: Array[String]) = {
    println(reverseBuiltin(List(1, 1, 2, 3, 5, 8)))
    println(reverseRecursive(List(1, 1, 2, 3, 5, 8)))
    println(reverseTailRecursive(List(1, 1, 2, 3, 5, 8)))
  }
}
