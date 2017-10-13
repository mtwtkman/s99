package mtwtkman.s99.p10

import mtwtkman.s99.p09.P09.pack

object P10 {
  def encode[A](ls: List[A]): List[(Int, A)] =
    pack(ls).map(e => (e.length, e.head))

  def main(args: Array[String]) = {
    println(encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}
