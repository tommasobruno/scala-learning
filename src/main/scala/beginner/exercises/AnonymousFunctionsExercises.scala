package org.scala.learning
package beginner.exercises

object AnonymousFunctionsExercises extends App {

  // Curried function
  val functionInFunction = new ((Int) => ((Int) => Int)) {
    override def apply(x: Int): Int => Int = {
      def random(r: Int): Int = {
        x + r
      }

      random
    }
  }

  // Lambda version
  val functionInFunctionBetter: (Int => Int => Int) = (x: Int) => (y: Int) => x + y
  println(functionInFunctionBetter(3)(4))

  val functionInFunctionBetterM = { (x: Int) =>
    { (y: Int) =>
      x + y
    }
  }

  println(functionInFunctionBetterM(4)(5))
}
