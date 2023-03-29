package org.scala.learning
package beginner.exercises

object PatternMatchingExercises extends App {

  /*
  Exercises
  */

  trait Expression
  case class Number(n: Int) extends Expression
  case class Sum(el: Expression, el2: Expression) extends Expression
  case class Product(el: Expression, el2: Expression) extends Expression

  def show(e: Expression): String = e match {
    case Number(v) => s"$v"
    case Sum(v1, v2) => show(v1) + " + " + show(v2)
    case Product(v1, v2) =>
      def maybeParenthesis(exp: Expression) = exp match {
        case Product(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }

      maybeParenthesis(v1) + " * " + maybeParenthesis(v2)
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Product(Number(2), Number(3))))
  println(show(Product(Sum(Number(2), Number(3)), Number(5))))
}
