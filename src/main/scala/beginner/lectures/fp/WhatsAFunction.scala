package org.scala.learning
package beginner.lectures.fp

object WhatsAFunction extends App {

  // Use and work with functions as first class elements
  // Work with functions as plain values
  // problem: oop
  trait MyFunction[A, B] {
    def apply(element: A): B
  }

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(3))

  // function types = Function1[A, B] ... Function22
  val stringToIntConverter = new Function[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)


  // ALL SCALA FUNCTIONS ARE OBJECTS
}