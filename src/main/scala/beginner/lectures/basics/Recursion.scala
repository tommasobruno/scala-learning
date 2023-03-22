package org.scala.learning
package beginner.lectures.basics

import scala.annotation.tailrec

object Recursion extends App {

  /*
  Exercises
   */

  // 1. Concatenate a string n times

  private def concatNTimes(v: String, t: Int): String = {

    @tailrec
    def concatHelper(v: String, t: Int, acc: String): String = {
      if (t <= 0) acc
      else concatHelper(v, t - 1, v + acc)
    }
    concatHelper(v, t, "")
  }

  println(concatNTimes("Hello", 3))

  // 2. isPrime function
  private def isPrime(t: Int): Boolean = {

    @tailrec
    def isPrimeHelper(n: Int, acc: Boolean): Boolean = {
      if(!acc) false
      else if (n <= 1) true
      else isPrimeHelper(n - 1, n % t != 0 && acc)
    }
    isPrimeHelper(t / 2, true)
  }
  println(isPrime(2003))
  println(isPrime(629))

  // 3. Fibonacci number
  private def fibonacci(limit: Int): Int = {

    @tailrec
    def fibonacciHelper(i: Int, last: Int, nextToLast: Int): Int = {
      if(i >= limit) last
      else fibonacciHelper(i + 1, last + nextToLast, last)
    }
    if(limit <= 2) 1
    else fibonacciHelper(2, 1, 1)
  }
  println(fibonacci(8))
}
