package mtwtkman.s99.p06

object P06 {
  // Find out whether a list is a palindrome.
  def isPalindrome[A](ls: List[A]): Boolean = ls == ls.reverse

  def main(args: Array[String]) = {
    println(isPalindrome(List(1, 2, 3, 2, 1)))
  }
}
