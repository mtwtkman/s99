package mtwtkman.s99.p17

object P17 {
  // Split a list into two parts.
  def splitBuiltin[A](n: Int, ls: List[A]): (List[A], List[A]) = ls.splitAt(n)

  def splitRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = (n, ls) match {
    case (_, Nil) => (Nil, Nil)
    case (0, list) => (Nil, list)
    case (n, h :: tail) => {
      val (pre, post) = splitRecursive(n - 1, tail)
      (h :: pre, post)
    }
  }

  def splitTailRecursive[A](n: Int, ls: List[A]): (List[A], List[A]) = {
    def splitR[A](c: Int, curList: List[A], pre: List[A]): (List[A], List[A]) = (c, curList) match {
      case (_, Nil) => (pre.reverse, Nil)
      case (0, list) => (pre.reverse, list)
      case (n, h :: tail) => splitR(n - 1, tail, h :: pre)
    }
    splitR(n, ls, Nil)
  }

  def splitFunctional[A](n: Int, ls: List[A]): (List[A], List[A]) =
    (ls.take(n), ls.drop(n))

  def main(args: Array[String]) {
    println(splitBuiltin(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitTailRecursive(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(splitFunctional(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}
