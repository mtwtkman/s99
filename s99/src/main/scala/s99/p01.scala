package mtwtkman.s99.p01

object P01 {
  // Find the last element of a list.
  def lastBuiltin[A](ls: List[A]): A = ls.last
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  def main(args: Array[String]) = {
    println(lastBuiltin(List(1, 1, 2, 3, 5, 8)))
    println(lastRecursive(List(1, 1, 2, 3, 5, 8)))
  }
}
