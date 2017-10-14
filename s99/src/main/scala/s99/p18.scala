package mtwtkman.s99.p18

object P18 {
  // Extract a slice from a list.
  def sliceBuiltin[A](i: Int, k: Int, ls: List[A]): List[A] = ls.slice(i, k)

  def sliceRecursive[A](start: Int, end: Int, ls: List[A]): List[A] =
    (start, end, ls) match {
      case (_, _, Nil) => Nil
      case (_, e, _) if e <= 0 => Nil
      case (s, e, h :: tail) if s <= 0 => h :: sliceRecursive(0, e - 1, tail)
      case (s, e, _ :: tail) => sliceRecursive(s - 1, e - 1, tail)
    }

  def sliceTailRecursive[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR[A](count: Int, curList: List[A], result: List[A]): List[A] =
      (count, curList) match {
        case (_, Nil) => Nil
        case (c, h :: tail) if end <= c => result.reverse
        case (c, h :: tail) if start <= c => sliceR(c + 1, tail, h :: result)
        case (c, _ :: tail) => sliceR(c + 1, tail, result)
      }
    sliceR(0, ls, Nil)
  }

  def sliceTailRecursive2[A](start: Int, end: Int, ls: List[A]): List[A] = {
    def sliceR[A](count: Int, curList: List[A], result: List[A]): List[A] =
      if (ls.isEmpty || count >= end) result.reverse
      else sliceR(
        count + 1, curList.tail,
        if (start <= count) curList.head :: result
        else result
      )
    sliceR(0, ls, Nil)
  }

  def sliceFunctional[A](s: Int, e: Int, ls: List[A]): List[A] =
    ls drop s take (e - (s max 0))

  def main(args: Array[String]) {
    println(sliceBuiltin(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceRecursive(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceTailRecursive(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceTailRecursive2(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
    println(sliceFunctional(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}
