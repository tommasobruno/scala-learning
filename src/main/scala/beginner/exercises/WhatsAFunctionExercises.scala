package org.scala.learning
package beginner.exercises

object WhatsAFunctionExercises extends App {

  /*
  Exercises
   */
  val concatStrings = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = s"$v1$v2"
  }
  println(concatStrings("James", "Bond"))

  // Curried function
  val functionInFunction = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = {
      def random(r: Int): Int = {
        x + r
      }
      random
    }
  }

  val addThree = functionInFunction(3)

  println(functionInFunction(2)(3))
  println(addThree(5))
}
