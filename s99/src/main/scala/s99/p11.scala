package mtwtkman.s99.p11

import mtwtkman.s99.p10.P10.encode

object P11 {
  // Modified run-length encoding.
  def encodeModified[A](ls: List[A]): List[Any] =
    encode(ls) map { t => if (t._1 == 1) t._2 else t }

  def encodeModified2[A](ls: List[A]): List[Either[A, (Int, A)]] =
    encode(ls) map { t => if (t._1 == 1) Left(t._2) else Right(t) }

  def main(args: Array[String]) = {
    println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
    println(encodeModified2(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}
