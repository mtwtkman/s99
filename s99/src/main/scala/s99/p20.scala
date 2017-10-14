package mtwtkman.s99.p20

object P20 {
  // Remove the Kth element from a list.
  def removeAt[A](n: Int, ls: List[A]): (List[A], A) = ls.splitAt(n) match {
    case (Nil, _) if n < 0 => throw new NoSuchElementException
    case (pre, e :: post) => (pre ::: post, e)
    case (pre, Nil) => throw new NoSuchElementException
  }

  def removeAt2[A](n: Int, ls: List[A]): (List[A], A) =
    if (n < 0) throw new NoSuchElementException
    else (n, ls) match {
      case (_, Nil) => throw new NoSuchElementException
      case (0, h :: tail) => (tail, h)
      case (_, h :: tail) => {
        val (t, e) = removeAt(n - 1, ls.tail)
        (ls.head :: t, e)
      }
    }

  def removeAtRecursive[A](n: Int, ls: List[A]): (List[A], A) = {
    def removeAtR[A](count: Int, curList: List[A], result: List[A]): List[A] =
      (count, curList) match {
        case (c, _ :: tail) if c == n => result.reverse ::: tail
        case (c, h :: tail) if c < n => removeAtR(c + 1, tail, h :: result)
        case (c, list) if c > n => result.reverse ::: list
      }
    (removeAtR(0, ls, Nil), ls(n))
  }

  def main(args: Array[String]) {
    println(removeAt(1, List('a, 'b, 'c, 'd)))
    println(removeAt2(1, List('a, 'b, 'c, 'd)))
    println(removeAtRecursive(1, List('a, 'b, 'c, 'd)))
  }
}
