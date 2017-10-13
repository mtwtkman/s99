package mtwtkman.s99.p02

object P02 {
  def penultimateBuiltin[A](ls: List[A]): A =
    if (ls.isEmpty) throw new NoSuchElementException
    else ls.init.last

  def penultimateRecursive[A](ls: List[A]): A = ls match {
    case h :: _ :: Nil => h
    case _ :: tail => penultimateRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  // Find the last but one element of a list.
  def main(args: Array[String]) = {
    println(penultimateBuiltin(List(1, 1, 2, 3, 5, 8)))
    println(penultimateRecursive(List(1, 1, 2, 3, 5, 8)))
  }
}
