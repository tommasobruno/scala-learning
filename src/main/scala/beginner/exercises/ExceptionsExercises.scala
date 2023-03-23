package org.scala.learning
package beginner.exercises

object ExceptionsExercises extends App {

  /*
  Exercises
   */

  // 1. Crash your program with an OutOfMemoryError
  val outOfMemoryError = new OutOfMemoryError
  // throw outOfMemoryError

  // 2. Crash your program with a SOError
  val soError = new StackOverflowError
  // throw soError

  // 3. PocketCalculator
  private class ExceptionClass(val reason: String) extends Exception {
    override def getMessage: String = s"Reason: $reason"
  }

  private class OverflowException extends ExceptionClass("Overflow")
  private class UnderflowException extends ExceptionClass("Underflow")
  private class MathCalculationException extends ExceptionClass("Division by 0")

  private abstract class PocketCalculator[T <: Integer] {
    def add(x: T, y: T): Unit
    def subtract(x: T, y: T): Unit
    def divide(x: T, y: T): Unit

    def multiple(x: T, y: T): Unit  = {
      println(x * y)
    }
    protected def matchCases[B <: ExceptionClass](input: Either[T, B]): Unit = {
      input match {
        case Right(x) => println(x.getMessage)
        case Left(y) => println(s"Number found: $y")
      }
    }
  }

  private val anonymousCalculator = new PocketCalculator[Integer] {
    override def add(x: Integer, y: Integer): Unit = {
      super.matchCases(if((x + y) > 10) Right(new OverflowException)
      else Left(x + y))
    }
    override def subtract(x: Integer, y: Integer): Unit = {
      super.matchCases(if ((x - y) < 10) Right(new UnderflowException)
      else Left(x - y))
    }

    override def divide(x: Integer, y: Integer): Unit = {
      super.matchCases(if (y == 0) Right(new MathCalculationException)
      else Left(x / y))
    }
  }

  anonymousCalculator.add(3, 3)
  anonymousCalculator.subtract(20, 18)
  anonymousCalculator.divide(3, 0)
  anonymousCalculator.multiple(3, 6)
}
