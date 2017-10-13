package mtwtkman.s99.p11

object P12 {
  def decode[A](ls: List[(Int, A)]): List[A] = {
    if (ls.isEmpty) Nil
    else {
      val (num, item) = ls.head
      List.fill(num)(item) ::: decode(ls.tail)
    }
  }

  def main(args: Array[String]) {
    println(decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  }
}
