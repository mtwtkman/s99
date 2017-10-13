package mtwtkman.s99.p08

object P08 {
  // Eliminate consecutive duplicates of list elements.
  def compressRecursive[A](ls: List[A]): List[A] = ls match {
    case Nil => Nil
    case h :: tail => h :: compressRecursive(tail.dropWhile(_ == h))
  }

  def compressTailRecursive[A](ls: List[A]): List[A] = {
    def compressR[A](result: List[A], curList: List[A]): List[A] = curList match {
      case Nil => result.reverse
      case h :: tail => compressR(h :: result, tail.dropWhile(_ == h))
    }
    compressR(Nil, ls)
  }
  def main(args: Array[String]) = {
    println(compressRecursive(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(compressTailRecursive(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}
