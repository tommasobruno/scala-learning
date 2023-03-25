package org.scala.learning
package beginner.lectures.fp

import scala.annotation.tailrec

object HOFAndCurries extends App {

  // High order function -> HOF
  //val superFunction: (Int, (String, (Int => Boolean)) => Int => (Int => Int)) = ???

  // Example, map, flatMap, filter because function as parameters

  // function that applies a function n times over a given value
  // nTimes(f, n, x) = f(f(f..(x)) = nTimes(f, n - 1, f(x))
  @tailrec
  private def nTimes(f: (Int => Int), n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }

  println(nTimes(x => x + 2, 2, 3))

  private def nTimesBetter(f: Int => Int, times: Int): Int => Int = {
    def interFunction(x: Int): Int = {
      if (times <= 0) x
      else nTimesBetter(f, times - 1)(f(x))
    }

    interFunction
   }

  private val tenTimes = nTimesBetter(x => x + 1, 5)
  println(tenTimes(6))

  // Curried functions
  val superOuterFunction: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  println(superOuterFunction(3)(5))

  // Function with multiple params list
  def curriedFormatter(format: String)(x: Double): String = format.format(x)
  val standardFormat: Double => String = curriedFormatter("%4.2f")

  println(standardFormat(Math.PI))
}
