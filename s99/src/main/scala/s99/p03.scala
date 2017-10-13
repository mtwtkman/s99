package mtwtkman.s99.p03

object P03 {
  // Find the Kth element of a list.
  def nthBuiltin[A](n: Int, ls: List[A]): A =
    if (n <= 0 || n >= ls.size) throw new NoSuchElementException
    else ls(n)

  def nthRecursive[A](n: Int, ls: List[A]): A = (n, ls) match {
    case (0, h :: _) => h
    case (x, _ :: tail) => nthRecursive(x-1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  def main(args: Array[String]) = {
    println(nthBuiltin(2, List(1, 1, 2, 3, 5, 8)))
    println(nthRecursive(2, List(1, 1, 2, 3, 5, 8)))
  }
}
